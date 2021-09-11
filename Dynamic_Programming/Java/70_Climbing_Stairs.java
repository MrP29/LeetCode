//Iterative Fibonacci Sequence (Time: O(N) Space: O(1))
class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        
        int prev = 1;
        int cur = 2;
        for(int i = 3; i <= n; i++) {
            int next = cur + prev;
            prev = cur;
            cur = next;
        }
        return cur;
    }
}

//Recursive Fibonacci Sequence(Time: O(N) Space: O(N))
public class Solution {
    int[] steps;
    
    public int climbStairs(int n) {
        steps = new int[n + 1];
        return stairsHelp(n);
    }
    
    private int stairsHelp(int n) {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        if(steps[n] > 0)
            return steps[n];
        
        steps[n] = stairsHelp(n - 1) + stairsHelp(n - 2);
        return steps[n];
    }
}

//Recursive Fibonacci Sequence(Time: O(N) Space: O(N))
public class Solution {
    int[] steps;
    
    public int climbStairs(int n) {
        steps = new int[n + 1];
        return stairsHelp(0, n);
    }
    
    private int stairsHelp(int i, int n) {
        if(i > n)
            return 0;
        if(i == n)
            return 1;
        if(steps[i] > 0)
            return steps[i];
        
        steps[i] = stairsHelp(i + 1, n) + stairsHelp(i + 2, n);
        return steps[i];
        
    }
}

//Fibonacci Formula by LeetCode (Time: O(logN) Space: O(1))
//Fn = 1 / sqrt5 [((1 + sqrt5) / 2)^n - ((1 - sqrt5) / 2)^n]
public class Solution {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt5)/2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fib / sqrt5);
    }
}