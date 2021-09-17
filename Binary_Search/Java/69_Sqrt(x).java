//Binary Search (Time: O(logN) Space: O(1))
class Solution {
    public int mySqrt(int x) {
        if(x < 2)
            return x;
        
        long num;
        int min = 2;
        int max = x / 2;
        int mid;
        while(min <= max) {
            mid = min + (max - min) / 2;
            num = (long)mid * mid;
            if(num == x)
                return mid;
            else if(num < x)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return max;
    }
}

//Recursion with Bit Manipulation by LeetCode (Time: O(logN) Space: O(logN))
class Solution {
    public int mySqrt(int x) {
        if(x < 2)
            return x;
        
        int left = mySqrt(x >> 2) << 1;
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}

//Calculator by LeetCode (Time: O(1) Space: O(1))
class Solution {
    public int mySqrt(int x) {
        if(x < 2)
            return x;
        
        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}