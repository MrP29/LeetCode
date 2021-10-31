//Greedy Algorithm (Time: O(N) Space: O(1))
class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int cur = 0;
        int farthest = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if(i == cur) {
                count++;
                cur = farthest;
            }
        }
        return count;
    }
}

//Dynamic Programming (Time: O(N^2) Space: O(N))
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length && j <= nums[i] + i; j++) {
                if(dp[j] == 0)
                    dp[j] = dp[i] + 1;
                else
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                
                if(dp[nums.length - 1] != 0)
                    return dp[nums.length - 1];
            }
        }
        return dp[nums.length - 1];
    }
}