//Expanding Window (Time: O(N^2) Space: O(1))
class Solution {
    public String longestPalindrome(String s) {
        int begin = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            int odd = expandString(s, i, i);
            int even = expandString(s, i, i + 1);
            int len = Math.max(odd, even);
            if(len > end - begin) {
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(begin, end + 1);
    }
    
    private int expandString(String s, int b, int e) {
        while(b >= 0 && e < s.length() && s.charAt(b) == s.charAt(e)) {
            b--;
            e++;
        }
        return e - b - 1;
    }
}

//Brutal Force (Time: O(N^3) Space: O(N))
class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for(int begin = 0; begin < s.length(); begin++) {
            for(int end = s.length() - 1; end + longest.length() >= begin; end--) {
                if(end - begin + 1 > longest.length() && s.charAt(begin) == s.charAt(end)) {
                    String curPalindrome = checkPalindrome(s, begin, end);
                    if(curPalindrome.length() > longest.length()) {
                        longest = curPalindrome;
                        break;
                    }
                }
            }
        }
        return longest;
    }
    
    private String checkPalindrome(String s, int b, int e) {
        String check = s.substring(b, e + 1);
        char[] ch = check.toCharArray();
        for(int i = 0; i < ch.length / 2; i++) {
            if(ch[i] != ch[ch.length - 1- i])
                return "";
        }
        return check;
    }
}