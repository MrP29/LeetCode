class Solution {
    public int rob(int[] nums) {
        int[] steal = new int[nums.length];
        steal[0] = nums[0];
        if(nums.length == 1)
            return steal[0];
        steal[1] = Math.max(steal[0], nums[1]);
        
        for(int i = 2; i < nums.length;i ++)
            steal[i] = Math.max(nums[i] + steal[i - 2], steal[i - 1]);

        return steal[steal.length - 1];
    }
}