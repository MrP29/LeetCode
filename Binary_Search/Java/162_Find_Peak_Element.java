//Iterative Binary Search (Time: O(logN) Space: O(1))
class Solution {
    public int findPeakElement(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        
        int mid;
        
        while(min < max) {
            mid = min + (max - min) / 2;
            
            if(nums[mid] > nums[mid + 1])
                max = mid;
            else
                min = mid + 1;
        }
        
        return min;
    }
}

//Recursive Binary Search (Time: O(logN) Space: O(logN))
class Solution {
    int[] nums;
    
    public int findPeakElement(int[] nums) {
        this.nums = nums;
        
        return search(0, nums.length - 1);
    }
    
    private int search(int min, int max) {
        if(min == max)
            return min;
        
        int mid = min + (max - min) / 2;
        if(nums[mid] > nums[mid + 1])
            return search(min, mid);
        
        return search(mid + 1, max);
    }
}

//Linear Search (Time: O(N) Space: O(1))
class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}