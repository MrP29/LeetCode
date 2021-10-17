//Binary Search (Time: O(logN) Space: O(1))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;
        
        int min = 0;
        int max = ROW * COL - 1;
        int mid, val;
        while(min <= max) {
            mid = min + (max - min) / 2;
            val = matrix[mid / COL][mid % COL];
            if(val == target)
                return true;
            else if(val < target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return false;
    }
}