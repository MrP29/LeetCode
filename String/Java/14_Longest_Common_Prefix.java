//Time: O(s) Space: O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int smallestLength = strs[0].length();
        for(int i = 1; i < strs.length; i++) {
            if(strs[i].length() < smallestLength)
                smallestLength = strs[i].length();
        }
        
        int count = 0;
        for(int i = 0; i < smallestLength; i++) {
            for(int j = 1; j < strs.length; j++) {
                if(strs[0].charAt(i) != strs[j].charAt(i))
                    return strs[0].substring(0, count);
            }
            count++;
        }
        return strs[0].substring(0, count);
    }
}

//Time: O(s) Space: O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}