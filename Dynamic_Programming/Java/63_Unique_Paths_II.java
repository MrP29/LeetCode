//Dynamic Programming (Time: O(N^2) Space: O(1))
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
            return 0;
        
        int ROW = obstacleGrid.length;
        int COL = obstacleGrid[0].length;

        obstacleGrid[0][0] = 1;
        for(int r = 1; r < ROW; r++)
            obstacleGrid[r][0] = obstacleGrid[r][0] == 0 ? obstacleGrid[r - 1][0] : 0;
        
        for(int c = 1; c < COL; c++)
            obstacleGrid[0][c] = obstacleGrid[0][c] == 0 ? obstacleGrid[0][c - 1] : 0;
        
        for(int r = 1; r < ROW; r++) {
            for(int c = 1; c < COL; c++) {
                if(obstacleGrid[r][c] == 1)
                    obstacleGrid[r][c] = 0;
                else
                    obstacleGrid[r][c] = obstacleGrid[r - 1][c] + obstacleGrid[r][c - 1];
            }
        }
        return obstacleGrid[ROW - 1][COL - 1];
    }
}