//Bottom-Up Iterative Optimized Dynamic Programming (Time: O(N) Space: O(1))
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

//Iterative Dynamic Programming from Left to Right (Time: O(N) Space: O(N))
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

//Iterative Dynamic Programming from Right to Left (Time: O(N) Space: O(N))
class Solution {
    public int rob(int[] nums) {
        int n = nums.length
        int[] steal = new int[n + 1];
        steal[n] = 0;
        steal[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--)
            steal[i] = Math.max(steal[i + 1] , steal[i + 2] + nums[i]);

        return steal[0];
    }
}

//Top-Down Recursive Dynamic Programming by LeetCode (Time: O(N) Space: O(N))
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