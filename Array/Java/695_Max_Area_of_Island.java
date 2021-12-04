//DFS (Time: O(N * M) Space: O(N * M))
class Solution {
    int[][] grid;
    int maxArea;
    int ROW;
    int COL;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.maxArea = 0;
        this.ROW = grid.length;
        this.COL = grid[0].length;
        
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, findMaxArea(r, c));
                }
            }
        }
        return maxArea;
    }
    
    private int findMaxArea(int r, int c) {
        if(r < 0 || r >= ROW || c < 0 || c >= COL || grid[r][c] == 0)
            return 0;
        
        grid[r][c] = 0;
        return findMaxArea(r - 1, c) + findMaxArea(r + 1, c) + findMaxArea(r, c - 1) + findMaxArea(r, c + 1) + 1;
    }
}

//BFS (Time: O(N * M) Space: O(N * M))
class Solution {
    int[][] grid;
    int ROW;
    int COL;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.ROW = grid.length;
        this.COL = grid[0].length;
        
        int maxArea = 0;
        
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, findMaxArea(r, c));
                }
            }
        }
        return maxArea;
    }
    
    private int findMaxArea(int r, int c) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{r, c});
        grid[r][c] = 0;
        int area = 0;
        
        while(!queue.isEmpty()) {
            r = queue.peek()[0];
            c = queue.poll()[1];
            area++;
            
            if(r > 0 && grid[r - 1][c] == 1) {
                queue.offer(new int[]{r - 1, c});
                grid[r - 1][c] = 0;
            }
            
            if(r < ROW - 1 && grid[r + 1][c] == 1) {
                queue.offer(new int[]{r + 1, c});
                grid[r + 1][c] = 0;
            }
            
            if(c > 0 && grid[r][c - 1] == 1) {
                queue.offer(new int[]{r, c - 1});
                grid[r][c - 1] = 0;
            }
            
            if(c < COL - 1 && grid[r][c + 1] == 1) {
                queue.offer(new int[]{r, c + 1});
                grid[r][c + 1] = 0;
            }
        }
        return area;
    }
}

//Iterative DFS by LeetCode (Time: O(N * M) Space: O(N * M))
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        int ans = 0;
        for (int r0 = 0; r0 < grid.length; r0++) {
            for (int c0 = 0; c0 < grid[0].length; c0++) {
                if (grid[r0][c0] == 1 && !seen[r0][c0]) {
                    int shape = 0;
                    Stack<int[]> stack = new Stack();
                    stack.push(new int[]{r0, c0});
                    seen[r0][c0] = true;
                    while (!stack.empty()) {
                        int[] node = stack.pop();
                        int r = node[0], c = node[1];
                        shape++;
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (0 <= nr && nr < grid.length &&
                                    0 <= nc && nc < grid[0].length &&
                                    grid[nr][nc] == 1 && !seen[nr][nc]) {
                                stack.push(new int[]{nr, nc});
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, shape);
                }
            }
        }
        return ans;
    }
}
