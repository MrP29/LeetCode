//Time: O(n*m) Space: O(1)
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int ROW = matrix.length;
        int COLUMN = matrix[0].length;
        
        int row = 0, column = 0;
        int direction = 1;
        int[] result = new int[ROW*COLUMN];
        int r = 0;

        while (row < ROW && column < COLUMN) {
            result[r++] = matrix[row][column];

            int new_row = row;
            int new_column = column;
            if(direction == 1)
                new_row--;
            else
                new_row++;
            if(direction == 1)
                new_column++;
            else
                new_column--;
            
            if (new_row < 0 || new_row == ROW || new_column < 0 || new_column == COLUMN) {
                if (direction == 1) {
                    if(column + 1 == COLUMN)
                        row++;
                    if(column + 1 < COLUMN)
                        column++;           
                } else {
                    if(row + 1 == ROW)
                        column++;
                    if(row + 1 < ROW)
                        row++;
                }
                direction = 1 - direction;               
            } else {
                row = new_row;
                column = new_column;
            }
        }
        return result;      
    }
}

//Time: O(n*m) Space: O(1)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        boolean up = true;
        int[] output = new int[mat.length * mat[0].length];
        int row = 0;
        int column = 0;
        
        for(int i = 0; i < output.length; i++) {
            output[i] = mat[row][column];
            if(up) {
                if(row - 1 < 0 && column + 1 >= mat[0].length) {
                    up = false;
                    row++;
                } else if(row - 1 < 0) {
                    up = false;
                    column++;
                } else if(column + 1 >= mat[0].length) {
                    up = false;
                    row++;
                } else {
                    row--;
                    column++;
                }
            } else {
                if(row + 1 >= mat.length && column - 1 < 0) {
                    up = true;
                    column++;
                } else if(column - 1 < 0) {
                    up = true;
                    row++;
                } else if(row + 1 >= mat.length) {
                    up = true;
                    column++;
                } else {
                    row++;
                    column--;
                }
            }
        }
        return output;
    }
}