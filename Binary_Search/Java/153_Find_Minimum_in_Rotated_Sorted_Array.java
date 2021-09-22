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