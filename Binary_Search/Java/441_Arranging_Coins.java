//Mathematics (Time: O(1) Space: O(1))
class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2 * (double)n + 0.25) - 0.5);
    }
}

//Binary Search (Time: O(logN) Space: O(1))
class Solution {
    public int arrangeCoins(int n) {
        long min = 0;
        long max = n;
        
        long mid = -1;
        long sum;
        while(min <= max) {
            mid = min + (max - min) / 2;
            sum = mid * (mid + 1) / 2;
            if(sum == n)
                return (int)mid;
            else if(sum < n)
                min = mid + 1;
            else
                max = mid - 1;
        }
        
        return (int)max;
    }
}