//Expand Window (Time: O(N^2) Space: O(1))
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            count += findPalindendome(s, i, i);
            count += findPalindendome(s, i, i + 1);
        }
        
        return count;
    }
    
    private int findPalindendome(String s, int begin, int end) {
        int count = 0;

        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
            count++;
        }
        
        return count;
        // return end - begin - 1;
    }
}

//Dynamic Programming by LeetCode (Time: O(N^2) Space: O(N^2))
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        
        for(int len = 3; len <= n; len++) {
            for(int i = 0, j = i + len - 1; j < n; i++, j++) {
                if(dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}

//Brute Force by LeetCode (Time: O(N^3) Space: O(1))
class Solution {
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) 
                return false;

            ++start;
            --end;
        }

        return true;
    }

    public int countSubstrings(String s) {
        int ans = 0;

        for (int start = 0; start < s.length(); ++start)
            for (int end = start; end < s.length(); ++end) 
                ans += isPalindrome(s, start, end) ? 1 : 0;

        return ans;
    }
}