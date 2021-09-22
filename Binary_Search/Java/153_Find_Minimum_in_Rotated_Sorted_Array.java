//Iterative Binary Search (Time: O(logN) Space: O(1))
class Solution {
    public int findMin(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        
        int mid;
        while(min < max) {
            mid = min + (max - min) / 2;
            if(nums[mid] < nums[max])
                max = mid;
            else
                min = mid + 1;
        }
        
        return nums[min];
    }
}

//Iterative Binary Search by LeetCode (Time: O(logN) Space: O(1))
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int min = 0;
        int max = nums.length - 1;
        
        if(nums[min] < nums[max])
            return nums[min];
        
        int mid;
        while(min <= max) {
            mid = min + (max - min) / 2;
            
            if(nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            
            if(nums[mid] < nums[mid - 1])
                return nums[mid];
            
            if(nums[mid] > nums[0])
                min = mid + 1;
            else
                max = mid - 1;
        }
        return -1;
    }
}