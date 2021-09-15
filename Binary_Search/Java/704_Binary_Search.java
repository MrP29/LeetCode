//Iteration (Time: O(logN) Space: O(1))
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right) {
            mid = left + ((right - left) / 2);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}

//Recursion (Time: O(logN) Space: O(logN))
class Solution {
    public int search(int[] nums, int target) {
        return recurSearch(nums, target, 0, nums.length - 1);
    }
    
    private int recurSearch(int[] nums, int target, int left, int right) {
        if(left > right)
            return -1;
        
        int mid = left + ((right - left) / 2);
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target)
            return recurSearch(nums, target, mid + 1, right);
        else
            return recurSearch(nums, target, left, mid - 1);
    }
}