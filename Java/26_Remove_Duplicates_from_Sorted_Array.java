class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        
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

// nums = [1, 1, 2, 3, 4, 4, 5] return 5

//     len = 5
// nums = [1, 2, 3, 4, 5, 4, 5]

// for (int i = 0; i < len; i++)
//     1 2 3 4 5