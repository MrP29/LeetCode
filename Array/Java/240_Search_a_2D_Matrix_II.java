//Iterative Reduce Matrix (Time: O(N) Space: O(1))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
}

//Recursive Reduce Matrix (Time: O(N) Space: O(N))
class Solution {
    int[][] matrix;
    int target;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        
        return search(0, matrix[0].length - 1);
    }
    
    private boolean search(int row, int col) {
        if(row >= this.matrix.length || col < 0)
            return false;
        
        if(this.matrix[row][col] == this.target)
            return true;
        else if(this.matrix[row][col] < this.target)
            return search(row + 1, col);
        return search(row, col - 1);
    }
}

//Divide and Conquer by LeetCode (Time: O(NlogN) Space: O(logN))
class Solution {
    int[][] matrix;
    int target;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        
        this.matrix = matrix;
        this.target = target;
        
        return search(0, 0, matrix[0].length - 1, matrix.length - 1);
    }
    
    private boolean search(int left, int up, int right, int down) {
        if(left > right || up > down)
            return false;
        else if(this.target < this.matrix[up][left] || this.target > matrix[down][right])
            return false;
        
        int mid = left + (right - left) / 2;
        int row = up;
        while(row <= down && this.matrix[row][mid] <= this.target) {
            if(this.matrix[row][mid] == target)
                return true;
            row++;
        }
        return search(left, row, mid - 1, down) || search(mid + 1, up, right, row - 1);
    }
}

//Binary Search by LeetCode (Time: O(NlogN) Space: O(1))
class Solution {
    int[][] matrix;
    int target;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        
        this.matrix = matrix;
        this.target = target;
        
        int shortLength = Math.min(matrix.length, matrix[0].length);
        for(int i = 0; i < shortLength; i++) {
            if(search(i, true) || search(i , false))
                return true;
        }
        return false;
    }
    
    private boolean search(int start, boolean vertical) {
        int min = start;
        int max = vertical ? matrix[0].length - 1 : matrix.length - 1;
        
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(vertical) {
                if(this.matrix[start][mid] == target)
                    return true;
                else if(this.matrix[start][mid] < target)
                    min = mid + 1;
                else
                    max = mid - 1;
            } else {
                if(this.matrix[mid][start] == target)
                    return true;
                else if(this.matrix[mid][start] < target)
                    min = mid + 1;
                else
                    max = mid - 1;
            }
        }
        return false;
    }
}