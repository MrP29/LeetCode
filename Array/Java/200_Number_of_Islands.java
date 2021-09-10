//DFS (Time: O(MN) Space: O(MN))
class Solution {
    char[][] grid;
    int island;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        island = 0;
        
        for(int r = 0; r < this.grid.length; r++) {
            for(int c = 0; c < this.grid[0].length; c++) {
                if(this.grid[r][c] == '1') {
                    search(r, c);
                    island++;
                }
            }
        }
        return island;
    }
    
    private void search(int r, int c) {
        if(r < 0 || c < 0 || r >= this.grid.length || c >= this.grid[0].length)
            return;
        
        if(this.grid[r][c] == '0')
            return;
        
        this.grid[r][c] = '0';
        search(r - 1, c);
        search(r, c - 1);
        search(r, c + 1);
        search(r + 1, c);
    }
}

//BFS by LeetCode (Time: O(MN) Space: O(Min(M, N)))
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        int ROW = grid.length;
        int COL = grid[0].length;
        int island = 0;
        
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                if(grid[r][c] == '1') {
                    island++;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList();
                    neighbors.add(r * COL + c);
                    while(!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / COL;
                        int col = id % COL;
                        if(row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * COL + col);
                            grid[row - 1][col] = '0';
                        }
                        if(row + 1 < ROW && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * COL + col);
                            grid[row + 1][col] = '0';
                        }
                        if(col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * COL + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if(col + 1 < COL && grid[row][col + 1] == '1') {
                            neighbors.add(row * COL + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return island;
    }
}

//Disjoint Set (Union Find) by LeetCode (Time: O(MN) Space: O(MN))
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int ROW = grid.length;
        int COL = grid[0].length;
        int island = 0;
        
        UnionFind uf = new UnionFind(grid);
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                if(grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if(r - 1 >= 0 && grid[r - 1][c] == '1')
                        uf.union(r * COL + c, (r - 1) * COL + c);
                    if(r + 1 < ROW && grid[r + 1][c] == '1')
                        uf.union(r * COL + c, (r + 1) * COL + c);
                    if(c - 1 >= 0 && grid[r][c - 1] == '1')
                        uf.union(r * COL + c, r * COL + c - 1);
                    if(c + 1 < COL && grid[r][c + 1] == '1')
                        uf.union(r * COL + c, r * COL + c + 1);
                }
            }
        }
        return uf.getCount();
    }
    
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;
        
        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }
        
        public int find(int i) {
            if(parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }
        
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if(rootx != rooty) {
                if(rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if(rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                count--;
            }
        }
        
        public int getCount() {
            return count;
        }
    }
}