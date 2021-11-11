//Dynamic Programming (Time: O(N) Space: O(1))
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }
    
    private int rob(int[] nums, int start, int end) {
        int prevprev = 0;
        int prev = 0;
        
        for(int i = start; i < end; i++) {
            int cur = Math.max(nums[i] + prevprev, prev);
            prevprev = prev;
            prev = cur;
        }
        return prev;
    }
}

//Dynamic Programming with Memo Table (Time: O(N) Space: O(N))
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        int[] dp2 = new int[nums.length];
        dp2[1] = nums[1];
        
        for(int i = 2; i < nums.length; i++) {
            if(i < nums.length - 1)
                dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
            
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        
        return Math.max(dp1[dp1.length - 2], dp2[dp2.length - 1]);
    }
}