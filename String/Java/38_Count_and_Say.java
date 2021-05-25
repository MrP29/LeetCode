import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Recursion with String (Time: O(n) Space: O(n))
class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        String str = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        
        int i = 0;
        while(i < str.length()) {
            int count = 1;
            while(i + count < str.length() && str.charAt(i) == str.charAt(i + count)) {
                count++;
            }
            result.append(Integer.toString(count));
            result.append(str.charAt(i));
            i = i + count;
        }
        return result.toString();
    }
}

//Regex (Time: O(n) Space: O(n))
class Solution {
    public String countAndSay(int n) {
        String currSeq = "1";
        
        String regexPattern = "(.)\\1*";
        Pattern pattern = Pattern.compile(regexPattern);
        
        for(int i = 1; i < n; i++) {
            Matcher m = pattern.matcher(currSeq);
            StringBuffer nextSeq = new StringBuffer();
            
            while(m.find()) {
                nextSeq.append(m.group().length() + String.valueOf(m.group().charAt(0)));
            }
            
            currSeq = nextSeq.toString();
        }
        return currSeq;
    }
}


