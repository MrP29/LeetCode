//Time: O(N^2) Space: O(N)
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowHigh = new int[grid.length];
        int[] colHigh = new int[grid[0].length];
        
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                rowHigh[row] = Math.max(rowHigh[row], grid[row][col]);
                colHigh[col] = Math.max(colHigh[col], grid[row][col]);
            }
        }
        
        int sum = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                sum += Math.min(rowHigh[row], colHigh[col]) - grid[row][col];
            }
        }
        return sum;
    }
}