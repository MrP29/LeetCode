class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int count = nums.length;
        for(int i = 0, j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j])
                nums[++i] = nums[j];
            else
                count--;
        }
        return count;
    }
}

// Two Pointer (LeetCode Solution)
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int index = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[index] != nums[j])
                nums[++index] = nums[j];
        }
        return index + 1;
    }
}