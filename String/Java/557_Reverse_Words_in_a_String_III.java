//Using StringBuilder reverse (Time: O(n) Space: O(n))
class Solution {
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int left = 0, right = 0;
        
        while(right < s.length()) {
            int next = s.indexOf(" ", right);
            right = next != -1 ? next : s.length();
            
            word.append(s.substring(left, right));
            reversed.append(word.reverse());
            reversed.append(" ");
            
            word.setLength(0);
            left = ++right;
        }
        return reversed.toString().trim();
    }
}

//Using StringBuilder insert (Time: O(n) Space: O(n))
class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        int first = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                str.insert(first, s.charAt(i));
            } else {
                str.append(" ");
                first = str.length();
            }
        }
        return str.toString();
    }
}

//Using Char Array (Time: O(n) Space: O(n))
class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        
        for(int right = 0; right < s.length(); right++) {
            while(right < s.length() && str[right] != ' ')
                right++;

            int wordEnd = right - 1;
            while(wordEnd > left) {
                char temp = str[left];
                str[left++] = str[wordEnd];
                str[wordEnd--] = temp;
            }
            left = ++right;
        }
        return String.valueOf(str);
    }
}

//Using StringBuilder append (Time: O(n) Space: O(n))
class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        int left = 0, right = 0;
        
        while(right < s.length()) {
            while(right < s.length() && s.charAt(right) != ' ') {
                right++;
            }
            int wordEnd = right - 1;
            while(wordEnd >= left) {
                str.append(s.charAt(wordEnd--));
            }
            left = ++right;
            if(left < s.length())
                str.append(" ");
        }
        return str.toString();
    }
}

//Using StringBuilder and reverse by LeetCode (Time: O(n) Space: O(n))
class Solution {
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                reversed.append(word.reverse());
                reversed.append(" ");
                word.setLength(0);
            }
        }
        reversed.append(word.reverse());
        return reversed.toString();
    }
}