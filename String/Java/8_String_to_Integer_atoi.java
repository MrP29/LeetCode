//Time: O(n) Space: O(n)
class Solution {
    public int myAtoi(String s) {
        String res = s.trim();
        char[] ch = res.toCharArray();
        
        if(ch.length == 0)
            return 0;
        
        char symbol = ' ';
        int num = 0;
        
        int i = 0;
        if(ch[0] == '-' || ch[0] == '+') {
            symbol = ch[0];
            i++;
        }
        
        while(i < ch.length && Character.isDigit(ch[i])) {
            int digit = Character.getNumericValue(ch[i]);
            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit)) {
                if(symbol == '+' || symbol == ' ')
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        if(symbol == '-')
            num = -num;

        return num;
    }
}