//Using Modulo Arithmetic (Time: O(NM) Space: O(NM))
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int total = ROW * COL;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        k = (total - (k % total)) % (total);
        int c = k % COL;
        int r = k / COL;
        for(int i = 0; i < ROW; i++) {
            List<Integer> arr = new ArrayList<>();
            for(int j = 0; j < COL; j++) {
                arr.add(grid[r][c++]);
                if(c >= COL) {
                    c = 0;
                    r++;
                }
                if(r >= ROW) {
                    r = 0;
                }
            }
            list.add(arr);
        }
        return list;
    }
}

//Using Modulo Arithmetic By LeetCode (Time: O(NM) Space: O(NM))
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int ROW = grid.length;
        int COL = grid[0].length;
        
        List<List<Integer>> list = new ArrayList();
        
        for(int r = 0; r < ROW; r++) {
            List<Integer> row = new ArrayList();
            list.add(row);
            for(int c = 0; c < COL; c++) {
                row.add(0);
            }
        }
        
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                int newCol = (c + k) % COL;
                int count = (c + k) / COL;
                int newRow = (r + count) % ROW;
                list.get(newRow).set(newCol, grid[r][c]);
            }
        }
        return list;
    }
}