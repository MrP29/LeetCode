//Doubling Divisor (Time: O((logN)^2) Time: O(1))
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        int totalCount = 0;
        boolean positive = false;
        
        if(dividend > 0) {
            dividend = -dividend;
            positive = !positive;
        }
        
        if(divisor > 0) {
            divisor = -divisor;
            positive = !positive;
        }
        
        while(dividend <= divisor) {
            int count = -1;
            int newDiv = divisor;
            while(newDiv + newDiv < newDiv && newDiv + newDiv >= dividend) {
                newDiv += newDiv;
                count += count;
            }
            
            dividend -= newDiv;
            totalCount -= count;
        }
        
        return positive ? -totalCount : totalCount;
    }
}

//Efficient Doubling Divisor with Bit Manipulation (Time: O(logN) Space: O(1))
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        int totalCount = 0;
        boolean positive = false;
        
        if(dividend > 0) {
            dividend = -dividend;
            positive = !positive;
        }
        
        if(divisor > 0) {
            divisor = -divisor;
            positive = !positive;
        }
        
        int newDiv = divisor;
        int count = -1;
        while(newDiv + newDiv < newDiv && dividend <= newDiv) {
            newDiv <<= 1;
            count <<= 1;
        }
        while(dividend <= divisor) {
            if(dividend <= newDiv) {
                dividend -= newDiv;
                totalCount -= count;
            }
            newDiv >>= 1;
            count >>= 1;
        }
        
        return positive ? -totalCount : totalCount;
    }
}

//Doubling Divisor with Auxiliary Stack (Time: O(logN) Space: O(logN))
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        int totalCount = 0;
        boolean positive = false;
        
        if(dividend > 0) {
            dividend = -dividend;
            positive = !positive;
        }
        
        if(divisor > 0) {
            divisor = -divisor;
            positive = !positive;
        }
        
        Stack<int[]> divisors = new Stack();
        int count = -1;
        divisors.push(new int[]{divisor, count});
        while(divisor + divisor < divisor && dividend <= divisor) {
            divisor += divisor;
            count += count;
            divisors.push(new int[]{divisor, count});
        }
        
        while(dividend < 0 && !divisors.isEmpty()) {
            int[] div = divisors.pop();
            if(dividend <= div[0]) {
                dividend -= div[0];
                totalCount -= div[1];
            }
        }
        
        return positive ? -totalCount : totalCount;
    }
}