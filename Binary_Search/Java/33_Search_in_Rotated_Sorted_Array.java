//One-pass Iterative Binary Search (Time: O(logN) Space: O(1))
class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        
        int mid;
        while(min <= max) {
            mid = min + (max - min) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] >= nums[min]) {
                if(nums[min] <= target && nums[mid] > target)
                    max = mid - 1;
                else
                    min = mid + 1;
            } else {
                if(nums[max] >= target && nums[mid] < target)
                    min = mid + 1;
                else
                    max = mid - 1;
            }
        }
        return -1;
    }
}

//Iterative Binary Search (Time: O(N) Space: O(1))
class Solution {
    int[] nums;
    int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        int pivot = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1])
                pivot = i;
        }
        
        if(pivot == 0)
            return searchHelper(0, nums.length - 1);
        else if(nums[0] <= target)
            return searchHelper(0, pivot - 1);
        return searchHelper(pivot, nums.length - 1);
    }

    private int searchHelper(int min, int max) {
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(this.nums[mid] == this.target)
                return mid;
            else if(this.nums[mid] < this.target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return -1;
    }        
}

//Recursive Binary Search (Time: O(N) Space: O(logN))
class Solution {
    int[] nums;
    int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        int pivot = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1])
                pivot = i;
        }
        
        if(pivot == 0)
            return searchHelper(0, nums.length - 1);
        else if(nums[0] <= target)
            return searchHelper(0, pivot - 1);
        return searchHelper(pivot, nums.length - 1); 
    }
    
    private int searchHelper(int min, int max) {
        if(min > max)
            return -1;

        int mid = min + (max - min) / 2;
        
        if(nums[mid] == this.target)
            return mid;
        else if(nums[mid] < this.target)
            return searchHelper(mid + 1, max);
        else
            return searchHelper(min, mid - 1);
    }
}