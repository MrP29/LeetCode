//Known Maximum Power of Three (Time: O(1) Space: (1))
class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

//Unknown Maximum Power of Three (Time: Unknown Space: O(1))
class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, Math.floor(Math.log10(Integer.MAX_VALUE) / Math.log10(3))) % n == 0;
    }
}

//Logarithms (Time: Unknown Space: O(1))
class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (Math.log(n) / Math.log10(3)) % 1 == 0;
    }
}

//Logarithms with Epsilon by LeetCode (Time: Unknown Space: O(1))
class Solution {
    public boolean isPowerOfThree(int n) {
        double epsilon = 0.00000000000001;
        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }
}

//Iteration (Time: O(logN) Space: O(1))
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 1)
            return false;
        
        while(n % 3 == 0)
            n /= 3;

        return n == 1;
    }
}

//Base Conversion by LeetCode (Time: O(logN) Space: O(logN))
class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}