//Array from left to right (Time: O(1) Space: O(1))
class Solution {
    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5 ,4, 1};
    static int[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length && num > 0; i++) {
            while(values[i] <= num) {
                num -= values[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}

//HashMap from left to right (Time: O(1) Space: O(1))
class Solution {
    static Map<Integer, String> romans = new HashMap<>();
    static {
        romans.put(1000, "M");
        romans.put(900, "CM");
        romans.put(500, "D");
        romans.put(400, "CD");
        romans.put(100, "C");
        romans.put(90, "XC");
        romans.put(50, "L");
        romans.put(40, "XL");
        romans.put(10, "X");
        romans.put(9, "IX");
        romans.put(5, "V");
        romans.put(4, "IV");
        romans.put(1, "I");
    }
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 3; i >= 0; i--) {
            int pow = (int)Math.pow(10, i);
            int n = num / pow;
            num -= n * pow;
            while(n > 0) {
                if(romans.containsKey(n * pow)) {
                    sb.append(romans.get(n * pow));
                    n -= n;
                } else if(n >= 5) {
                    sb.append(romans.get(5 * pow));
                    n -= 5;
                } else {
                    sb.append(romans.get(pow));
                    n--;
                }
            }
        } 
        return sb.toString();
    }
}

//HashMap from right to left (Time: O(1) Space: O(1))
class Solution {
    static Map<Integer, String> romans = new HashMap<>();
    static {
        romans.put(1000, "M");
        romans.put(900, "MC");
        romans.put(500, "D");
        romans.put(400, "DC");
        romans.put(100, "C");
        romans.put(90, "CX");
        romans.put(50, "L");
        romans.put(40, "LX");
        romans.put(10, "X");
        romans.put(9, "XI");
        romans.put(5, "V");
        romans.put(4, "VI");
        romans.put(1, "I");
    }
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; Math.pow(10, i) <= num; i++) {
            int pow = (int)Math.pow(10, i);
            int n = num % (pow * 10);
            num -= n;
            if(romans.containsKey(n)) {
                sb.append(romans.get(n));
            } else {
                for(int j = pow; j <= n; j += pow)
                    if(j + pow * 5 == n + pow) {
                        sb.append(romans.get(pow * 5));
                        j += pow * 5;
                    } else {
                        sb.append(romans.get(pow));
                    }
            }
        } 
        return sb.reverse().toString();
    }
}

//Hardcode Digits by LeetCode (Time: O(1) Space: (1))
class Solution { 
    private static final String[] thousands = {"", "M", "MM", "MMM"};
    private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
    private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
    public String intToRoman(int num) { 
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }
}