//Array List (Time: O(NM) Space: O(Max(N, M)))
class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeros = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    int[] points = {i, j};
                    zeros.add(points);
                }
            }
        }
        
        for(int i = 0; i < zeros.size(); i++) {
            int[] points = zeros.get(i);
            int row = zeros.get(i)[0];
            int col = zeros.get(i)[1];
            for(int r = 0; r < matrix.length; r++) {
                matrix[r][col] = 0;
            }
            for(int c = 0; c < matrix[0].length; c++) {
                matrix[row][c] = 0;
            }
        }
    }
}

//Hash Table (Time: O(NM) Space: O(Max(N, M)))
class Solution {
    public void setZeroes(int[][] matrix) {
        int ROW = matrix.length;
        int COL = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                if(matrix[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                if(rows.contains(r) || cols.contains(c))
                    matrix[r][c] = 0;
            }
        }
    }
}

//In Place by LeetCode (Time: O(NM) Space: O(1))
class Solution {
  public void setZeroes(int[][] matrix) {
    Boolean isCol = false;
    int ROW = matrix.length;
    int COL = matrix[0].length;

    for (int r = 0; r < ROW; r++) {
      if (matrix[r][0] == 0)
        isCol = true;

      for (int c = 1; c < COL; c++) {
        if (matrix[r][c] == 0) {
          matrix[0][c] = 0;
          matrix[r][0] = 0;
        }
      }
    }

    for (int r = 1; r < ROW; r++) {
      for (int c = 1; c < COL; c++) {
        if (matrix[r][0] == 0 || matrix[0][c] == 0)
          matrix[r][c] = 0;
      }
    }

    if (matrix[0][0] == 0) {
      for (int c = 0; c < COL; c++)
        matrix[0][c] = 0;
    }

    if (isCol) {
      for (int r = 0; r < ROW; r++)
        matrix[r][0] = 0;
    }
  }
}