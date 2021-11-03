//Recursive Backtracking (Time: O(2^N) Space: O(N))
class Solution {
    int[] nums;
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        return findSum(0, 0, 1) + findSum(0, 0, -1);
    }
    
    private int findSum(int sum, int index, int symbol) {
        sum += (symbol * this.nums[index]);
        if(index == this.nums.length - 1) {
            return sum == this.target ? 1 : 0;
        }
        
        return findSum(sum, index + 1, 1) + findSum(sum, index + 1, -1);
    }
}

//Recursive Backtracking with Memoization by LeetCode (Time: O(tN) Space: O(tN))
class Solution {
    int[] nums;
    int target;
    int total;
    int[][] memo;
    
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.total = Arrays.stream(nums).sum();
        memo = new int[nums.length][2 * this.total + 1];
        
        for(int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        
        return findSum(0, 0);
    }
    
    private int findSum(int index, int sum) {
        if(index == this.nums.length)
            return sum == this.target ? 1 : 0;
        
        if(this.memo[index][sum + total] != Integer.MIN_VALUE)
            return this.memo[index][sum + total];
        
        int add = findSum(index + 1, sum + this.nums[index]);
        int sub = findSum(index + 1, sum - this.nums[index]);
        memo[index][sum + this.total] = add + sub;
        return memo[index][sum + this.total];
    }
}

//Dynamic Programming by LeetCode (Time: O(tN) Space: O(t)) where t is the sum of the nums array
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int[] dp = new int[2 * total + 1];
        dp[nums[0] + total] = 1;
        dp[-nums[0] + total] += 1;
        
        for(int i = 1; i < nums.length; i++) {
            int[] next = new int[2 * total + 1];
            for(int sum = -total; sum <= total; sum++) {
                if(dp[sum + total] > 0) {
                    next[sum + nums[i] + total] += dp[sum + total];
                    next[sum - nums[i] + total] += dp[sum + total];
                }
            }
            dp = next;
        }
        return Math.abs(target) > total ? 0 : dp[target + total];
    }
}

//Dynamic Programming by LeetCode (Time: O(tN) Space: O(t)) where t is the sum of the nums array
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;
        
        for(int i = 1; i < nums.length; i++) {
            for(int sum = -total; sum <= total; sum++) {
                if(dp[i - 1][sum + total] > 0) {
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
        }
        return Math.abs(target) > total ? 0 : dp[nums.length - 1][target + total];
    }
}