//BFS (Time: O(N * M) Space: O(N * M))
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList();
        int freshOranges = 0;
        
        int ROW = grid.length;
        int COL = grid[0].length;
        
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                if(grid[r][c] == 2)
                    rotten.add(new int[]{r, c});
                else if(grid[r][c] == 1)
                    freshOranges++;
            }
        }
        rotten.add(null);
        
        int time = -1;
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while(!rotten.isEmpty()) {
            int[] loc = rotten.poll();
            if(loc == null) {
                time++;
                if(!rotten.isEmpty())
                    rotten.add(null);
            } else {
                for(int[] d: DIR) {
                    int adjRow = loc[0] + d[0];
                    int adjCol = loc[1] + d[1];
                    
                    if(adjRow >= 0 && adjRow < ROW && adjCol >= 0 && adjCol < COL && grid[adjRow][adjCol] == 1) {
                        grid[adjRow][adjCol] = 2;
                        freshOranges--;
                        rotten.add(new int[]{adjRow, adjCol});
                    }
                }
            }
        }
        
        return freshOranges == 0 ? time : -1;
    }
}

//In-place BFS (Time: O(N^2 * M^2) Space: O(1))
class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int timestamp = 2;
        while(runRottingProcess(timestamp, grid, ROW, COL))
            timestamp++;
        
        for(int[] r: grid) {
            for(int c: r) {
                if(c == 1)
                    return -1;
            }
        }
        
        return timestamp - 2;
    }
    
    private boolean runRottingProcess(int timestamp, int[][] grid, int ROW, int COL) {
        int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        boolean continued = false;
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                if(grid[r][c] == timestamp) {
                    for(int[] d: DIR) {
                        int adjRow = r + d[0];
                        int adjCol = c + d[1];
                        if(adjRow >= 0 && adjRow < ROW && adjCol >= 0 && adjCol < COL) {
                            if(grid[adjRow][adjCol] == 1) {
                                grid[adjRow][adjCol] = timestamp + 1;
                                continued = true;
                            }
                        }
                    }
                }
            }
        }
        return continued;
    }
}