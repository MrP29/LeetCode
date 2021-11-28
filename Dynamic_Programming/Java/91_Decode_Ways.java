//Dynamic Programming (Time: O(N) Space: O(1))
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        
        int n = s.length();
        int twoBefore = 1;
        int oneBefore = 1;
        
        for(int i = 1; i < n; i++) {
            int cur = 0;
            if(s.charAt(i) != '0')
                cur = oneBefore;
            
            int doubleDigit = Integer.valueOf(s.substring(i - 1, i + 1));
            if(doubleDigit > 9 && doubleDigit < 27)
                cur += twoBefore;
            
            twoBefore = oneBefore;
            oneBefore = cur;
        }
        return oneBefore;
    }
}

//Dynamic Programming with Array (Time: O(N) Space: O(N))
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
                        
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) != '0')
                dp[i + 1] = dp[i];
            
            int doubleDigit = Integer.valueOf(s.substring(i - 1, i + 1));
            if(doubleDigit > 9 && doubleDigit < 27)
                dp[i + 1] += dp[i - 1];
        }
        
        return dp[n];
    }
}

//Recursive Dynamic Programming with Memoization by LeetCode (Time: O(N) Space: O(N))
class Solution {
    Map<Integer, Integer> memo = new HashMap();
    
    public int numDecodings(String s) {
        return decode(0, s);
    }
    
    private int decode(int index, String str) {
        if(memo.containsKey(index))
            return memo.get(index);
        
        if(index == str.length())
            return 1;
        
        if(str.charAt(index) == '0')
            return 0;
        
        if(index == str.length() - 1)
            return 1;
        
        int ans = decode(index + 1, str);
        if(Integer.valueOf(str.substring(index, index + 2)) < 27)
            ans += decode(index + 2, str);
        
        memo.put(index, ans);
        
        return ans;
    }
}