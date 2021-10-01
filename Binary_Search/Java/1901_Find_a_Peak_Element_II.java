//Binary Search (Time: O(NlogM) Space: O(1))
class Solution {
    int[][] mat;
    
    public int[] findPeakGrid(int[][] mat) {
        this.mat = mat;
        
        int min = 0;
        int max = mat[0].length;
        int mid;
        
        while(min < max) {
            mid = min + (max - min) / 2;
            int rowPeak = rowSearch(mid);

            int peak = mat[rowPeak][mid];
            int left = mid > 0 ? mat[rowPeak][mid - 1] : -1;
            int right = mid < mat[0].length - 1 ? mat[rowPeak][mid + 1] : -1;

            if(peak > left && peak > right)
                return new int[] {rowPeak, mid};
            else if(peak > left)
                min = mid + 1;
            else
                max = mid;
        }
        return new int[] {-1, -1};
    }

    private int rowSearch(int col) {
        int max = 0;
        for(int i = 1; i < this.mat.length; i++) {
            if(this.mat[i][col] > this.mat[max][col])
                max = i;
        }
        return max;
    }
}

//Binary Search by LeetCode Discuss (Time: O(MlogN) Space: O(1))
//https://leetcode.com/problems/find-a-peak-element-ii/discuss/1276556/JavaPythonC%2B%2B-Clear-Explanation-with-Images-or-M*Log(N)-or-Very-Short-code
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int min = 0;
        int max = mat[0].length - 1;

        while(min <= max) {
            int maxRow = 0;
            int mid = min + (max - min) / 2;

            for(int r = 0; r < mat.length; r++) {
                maxRow = mat[r][mid] >= mat[maxRow][mid] ? r : maxRow;
            }

            boolean leftIsBig = mid > min && mat[maxRow][mid - 1] > mat[maxRow][mid];
            boolean rightIsBig = mid < max && mat[maxRow][mid + 1] > mat[maxRow][mid];

            if(!leftIsBig && !rightIsBig)
                return new int[] {maxRow, mid};
            else if(leftIsBig)
                max = mid - 1;
            else
                min = mid + 1;
        }
        return new int[] {-1, -1};
    }
}