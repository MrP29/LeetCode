//Using char (Time: O(MAX(N1, N2)) Space: O(MAX(N1, N2)))
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int up = 0;
        
        for(int i = 0; i < num1.length() || i < num2.length(); i++) {
            char n1 = i < num1.length() ? num1.charAt(num1.length() - 1 - i) : '0';
            char n2 = i < num2.length() ? num2.charAt(num2.length() - 1 - i) : '0';
            
            int n = n1 + n2 - '0' + up;
            up = n > '9' ? 1 : 0;
            if(up == 1)
                n -= 10;
            sb.append((char)n);
        }
        
        if(up == 1)
            sb.append('1');
        
        return sb.reverse().toString();
    }
}

//Using int (Time: O(MAX(N1, N2)) Space: O(MAX(N1, N2)))
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int up = 0;
        for(int i = 0; i < num1.length() || i < num2.length(); i++) {
            int n1 = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int n2 = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;

            int n = (n1 + n2 + up) % 10;
            up = (n1 + n2 + up) / 10;
            sb.append(n);     
        }

        if(up == 1)
            sb.append(1);

        return sb.reverse().toString();
    }
}