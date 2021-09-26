//Iterative Quick Select (Time: O(N) Space: O(1)) Worst Case - O(N^2)
class Solution {
    int[] nums;
    
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        
        int min = 0;
        int max = nums.length - 1;
        
        int pivot;
        do {
            pivot = sort(min, max);
            
            if(pivot < nums.length - k)
                min = pivot + 1;
            else if(pivot > nums.length - k)
                max = pivot - 1;
            
        } while(pivot != nums.length - k);
        
        return nums[pivot];
    }
    
    private int sort(int min, int max) {
        if(min == max)
            return min;
        
        Random rng = new Random();
        int pivot = min + rng.nextInt(max - min);
        
        swap(pivot, max);
        for(int i = min; i < max; i++) {
            if(this.nums[i] < this.nums[max]) {
                swap(i, min++);
            }
        }
        swap(min, max);
        return min;
    }
    
    private void swap(int left, int right) {
        int temp = this.nums[left];
        this.nums[left] = this.nums[right];
        this.nums[right] = temp;
    }
}


//Recursive Quick Select by LeetCode (Time: O(N) Space: O(1)) Worst Case - O(N^2)
class Solution {
    int[] nums;
    int k;
    
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.k = nums.length - k;

        return quickSelect(0, nums.length - 1);
    }
    
    private int quickSelect(int min, int max) {
        if(min == max)
            return this.nums[min];
        
        Random rng = new Random();
        int pivot = min + rng.nextInt(max - min);
        
        pivot = partition(min, max, pivot);
        
        if(this.k == pivot)
            return this.nums[k];
        else if(this.k < pivot)
            return quickSelect(min, pivot - 1);
        
        return quickSelect(pivot + 1, max);
    }
    
    private int partition(int min, int max, int pivot_idx) {
        int pivot = this.nums[pivot_idx];
        swap(pivot_idx, max);
        
        for(int i = min; i <= max; i++) {
            if(this.nums[i] < pivot)
                swap(min++, i);
        }
        
        swap(min, max);
        return min;
    }
    
    private void swap(int left, int right) {
        int temp = this.nums[left];
        this.nums[left] = this.nums[right];
        this.nums[right] = temp;
    }
}

//Sorting (Time: O(NlogN) Space: O(1))
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

//Priority Queue (Time: O(NlogK) Space: O(K))
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        
        for(int n: nums) {
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        
        return pq.poll();
    }
}