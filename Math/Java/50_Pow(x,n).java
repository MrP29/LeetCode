//Recursion (Time: O(logN) Space: O(logN))
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return pow(x, N);
    }
    
    private double pow(double x, long n) {
        if(n == 0)
            return 1.0;
        
        double half = pow(x, n / 2);
        if(n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
}

//Iteration by LeetCode (Time: O(logN) Space: O(1))
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double ans = 1;
        double current_product = x;
        for(long i = N; i > 0; i /= 2) {
            if(i % 2 == 1)
                ans = ans * current_product;
            
            current_product *= current_product;
        }
        return ans;
    }
}