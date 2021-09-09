//Recursion with Hash Map (Time: O(N) Space: O(N))
class Solution {
    Map<Integer, Integer> cache = new HashMap();
    
    public int fib(int n) {
        if(n < 2)
            return n;
        
        if(cache.containsKey(n))
            return cache.get(n);
        
        cache.put(n, fib(n - 1) + fib(n - 2));
        return cache.get(n);
    }
}

//Iteration with Array (Time: O(N) Space: O(N))
class Solution {
    public int fib(int n) {
        if(n < 2)
            return n;
        
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for(int i = 2; i <= n; i++)
            cache[i] = cache[i - 1] + cache[i - 2];
        
        return cache[n];
    }
}

//Iteration (Time: O(N) Space: O(1))
class Solution {
    public int fib(int n) {
        if(n < 2)
            return n;
        
        int cur = 1;
        int prev = 0;

        for(int i = 2; i <= n; i++) {
            int temp = cur + prev;
            prev = cur;
            cur = temp;
        }
        return cur;
    }
}

//Mathmatics (Time: O(logN) Space: O(1))
class Solution {
    public int fib(int n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
    }
}

//Matrix Exponentiation by LeetCode (Time: O(logN) Space: O(logN))
class Solution {
    public int fib(int n) {
        if(n < 2)
            return n;
        
        int[][] ans = new int[][]{{1, 1}, {1, 0}};
        matrixPower(ans, n - 1);
        
        return ans[0][0];
    }
    
    private void matrixPower(int[][] ans, int n) {
        if(n < 2)
            return;
        
        matrixPower(ans, n / 2);
        multiply(ans, ans);
        
        int[][] b = new int[][]{{1, 1}, {1, 0}};
        if(n % 2 != 0)
            multiply(ans, b);
    }
    
    private void multiply(int[][] a, int[][] b) {
        int x1 = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        int y1 = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        int x2 = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        int y2 = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        
        a[0][0] = x1;
        a[0][1] = y1;
        a[1][0] = x2;
        a[1][1] = y2;
    }
}