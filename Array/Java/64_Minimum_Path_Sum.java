//Dynamic Programming 2D in place (Time: O(NM) Space: O(1))
class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 1; i < grid[0].length; i++)
            grid[0][i] += grid[0][i - 1];
        
        for(int i = 1; i < grid.length; i++)
            grid[i][0] += grid[i - 1][0];

        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

//Dynamic Programming 2D in place (Time: O(NM) Space: O(1))
class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            if(i + 1 < grid.length) {
                grid[i + 1][0] += grid[i][0];
            }
            for(int j = 0; j < grid[0].length - 1; j++) {
                if(i == 0) {
                    grid[i][j + 1] += grid[i][j];
                } else {
                    grid[i][j + 1] += grid[i - 1][j + 1] < grid[i][j] ? grid[i - 1][j + 1] : grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

//Dynamic Programming 2D (Time: O(NM) Space: O(NM))
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j != 0)
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if(j == 0 && i != 0)
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                else if(j != 0 && i != 0)
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

//Dynamic Programming 1D by LeetCode (Time: O(NM) Space: O(N))
class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }
}