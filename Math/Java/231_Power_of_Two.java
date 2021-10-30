//Time: O(logN) Space: O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1)
            return false;
        
        while(n > 1) {
            if(n % 2 == 0)
                n /= 2;
            else
                return false;
        }
        return true;
    }
}

//Turn off the Rightmost 1-bit by LeetCode (Time: O(1) Space: O(1))
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1)
            return false;
        return (n & (n - 1)) == 0;
    }
}

//Get the Rightmost 1-bit by LeetCode (Time: O(1) Space: O(1))
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1)
            return false;
        return (n & (-n)) == n;
    }
}
