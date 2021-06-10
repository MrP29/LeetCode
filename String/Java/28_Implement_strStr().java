//String comparison (Time: O(n) Space: O(n))
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            String sub = haystack.substring(i, i + needle.length());
            if(sub.equals(needle))
                return i;
        }
        return -1;
    }
}

//Character comparison (Time: O(n*m) Space: O(1))
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while(j < needle.length() && haystack.charAt(i + j) == needle.charAt(j))
                j++;
            if(j >= needle.length())
                return i;
        }
        return -1;
    }
}

//Using indexOf method (Time: O(n) Space: O(1))
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}