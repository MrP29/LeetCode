//Binary Search (Time: O(logN) Space: O(1))
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        
        int min = 1;
        int max = num / 2;
        
        long mid, sq;
        while(min <= max) {
            mid = min + (max - min) / 2;
            sq = mid * mid;
            if(sq == num)
                return true;
            else if(sq < num)
                min = (int)mid + 1;
            else
                max = (int)mid - 1;
        }

        return false;
    }
}

//Newton's Method by LeetCode (Time: O(logN) Space: O(1))
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        
        long x = num / 2;
        while(x * x > num)
            x = (x + num / x) / 2;
        
        return x * x == num;
    }
}