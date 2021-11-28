//Dynamic Programming
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(mapped(s, i, i + 1))
                    dp[0] = 1;
            } else if(i == 1) {
                if(mapped(s, i, i + 1))
                    dp[1] = dp[0];
                if(mapped(s, i - 1, i + 1))
                    dp[1] = dp[1] + 1;
            } else {
                if(dp[i - 1] != 0 && mapped(s, i, i + 1))
                    dp[i] = dp[i - 1];
                if(dp[i - 2] != 0 && mapped(s, i - 1, i + 1))
                    dp[i] = dp[i - 2] + dp[i];
            }
        }
        
        return dp[n - 1];
    }
    
    private boolean mapped(String s, int start, int end) {
        if(start + 1 == end) {
            int n1 = Integer.valueOf(s.substring(start, end));
            return n1 != 0;
        } else {
            int n1 = Integer.valueOf(s.substring(start, end - 1));
            int n2 = Integer.valueOf(s.substring(start, end));
            return n1 != 0 && n2 < 27;
        }
    }
}

//Time Out
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        if(s.length() > 0) {
            if(mapped(s, 0, 1))
                dp[0] = 1;
        }
        
        if(s.length() > 1) {
            if(mapped(s, 1, 2))
                dp[1] = dp[0];
            if(mapped(s, 0, 2))
                dp[1] = dp[0] + 1;
        }
                        
        for(int i = 2; i < n; i++) {
            if(dp[i - 1] != 0 && mapped(s, i, i + 1))
                dp[i] = dp[i - 1];
            if(dp[i - 2] != 0 && mapped(s, i - 1, i + 1))
                dp[i] = dp[i - 2] + dp[i];
        }
        
        return dp[n - 1];
    }
    
    private boolean mapped(String s, int start, int end) {
        if(start + 1 == end) {
            int n1 = Integer.valueOf(s.substring(start, end));
            return n1 != 0;
        } else {
            int n1 = Integer.valueOf(s.substring(start, end - 1));
            int n2 = Integer.valueOf(s.substring(start, end));
            return n1 != 0 && n2 < 27;
        }
    }
}



class Solution {
    int decoded;
    
    public int numDecodings(String s) {
        decoded = 0;
        decode(s);
        return decoded;
    }
        
    private void decode(String s) {
        if(s.length() == 0) {
            decoded++;
            return;
        }

        int n1 = Integer.valueOf(s.substring(0, 1));
        if(n1 == 0) //< 1 || n1 > 26)
            return;
        decode(s.substring(1, s.length()));


        if(s.length() < 2)
            return;
        
        if(Integer.valueOf(s.substring(0, 2)) <= 26)
            decode(s.substring(2, s.length()));
    }
}
*/


//Time Out
class Solution {
    Set<String> codes;
    int decoded;
    public int numDecodings(String s) {
        init();
        decoded = 0;
        
        decode(s);
        return decoded;
    }
    
    private void decode(String s) {
        if(s.length() == 0) {
            decoded++;
            return;
        }
    
        if(s.length() > 0 && codes.contains(s.substring(0, 1))) {
            decode(s.substring(1, s.length()));
        }
        
        if(s.length() > 1 && codes.contains(s.substring(0, 2))) {
            decode(s.substring(2, s.length()));
        }
    }
    
    private void init() {
        codes = new HashSet();
        for(int i = 1; i <= 26; i++) {
            codes.add(String.valueOf(i));
        }
    }
}
