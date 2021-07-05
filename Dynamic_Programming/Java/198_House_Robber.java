//Iteration (Time: O(n) Space: O(1))
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int beforePrev = nums[0];
        int prev = Math.max(beforePrev, nums[1]);
        
        for(int i = 2; i < nums.length;i ++) {
            int cur = Math.max(nums[i] + beforePrev, prev);
            beforePrev = prev;
            prev = cur;
        }
        return prev;
    }
}

//Iteration (Time: O(n) Space: O(n))
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int[] steal = new int[nums.length];
        steal[0] = nums[0];
        steal[1] = Math.max(steal[0], nums[1]);
        
        for(int i = 2; i < nums.length;i ++)
            steal[i] = Math.max(nums[i] + steal[i - 2], steal[i - 1]);

        return steal[steal.length - 1];
    }
}

//Recursion by LeetCode (Time: O(n) Space: O(n))
class Solution {
    private int[] memo;
    
    public int rob(int[] nums) {
        memo = new int[100];
        Arrays.fill(memo, -1);
        
        return robFrom(0, nums);
    }
    
    private int robFrom(int i, int[] nums) {
        if(i >= nums.length)
            return 0;
        
        if(memo[i] > -1)
            return memo[i];
        
        int sum = Math.max(robFrom(i + 1, nums), robFrom(i + 2, nums) + nums[i]);
        memo[i] = sum;
        return sum;
    }
}