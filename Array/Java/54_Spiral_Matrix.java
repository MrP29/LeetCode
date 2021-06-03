//Time: O(n*m) Space: O(n*m)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        int ROW = matrix.length, COL = matrix[0].length;
        int row = 0, col = 0, direction = 0;
        boolean[][] visited = new boolean[ROW][COL];
        
        for(int i = 0; i < ROW * COL; i++) {
            arr.add(matrix[row][col]);
            visited[row][col] = true;
            int new_row = row;
            int new_col = col;
            
            switch(direction % 4) {
                case 0: new_col++; break;
                case 1: new_row++; break;
                case 2: new_col--; break;
                case 3: new_row--; break;
                default: break;
            }

            if(new_row < 0 || new_row == ROW || new_col < 0 || new_col == COL || visited[new_row][new_col]) {
                switch(direction % 4) {
                    case 0: row++; break;
                    case 1: col--; break;
                    case 2: row--; break;
                    case 3: col++; break;
                    default: break;
                }
                direction++;
            } else {
                row = new_row;
                col = new_col;
            }
        }
        return arr;
    }
}

//Time: O(n*m) Space: O(n*m)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        int ROW = matrix.length, COL = matrix[0].length;
        int row = 0, col = 0, direction = 0, bound = 0;
        
        for(int i = 0; i < ROW * COL; i++) {
            arr.add(matrix[row][col]);
            int new_row = row;
            int new_col = col;
            bound = (direction + 1) / 4;
            
            switch(direction % 4) {
                case 0: new_col++; break;
                case 1: new_row++; break;
                case 2: new_col--; break;
                case 3: new_row--; break;
                default: break;
            }
            
            if(direction % 4 == 0 && new_col == COL - bound) {
                row++;
                direction++;
            } else if(direction % 4 == 1 && new_row == ROW - bound) {
                col--;
                direction++;
            } else if(direction % 4 == 2 && new_col < 0 + bound) {
                row--;
                direction++;
            } else if(direction % 4 == 3 && new_row < 0 + bound) {
                col++;
                direction++;
            } else {
                row = new_row;
                col = new_col;
            }
        }
        return arr;
    }
}