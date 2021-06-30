//If-else (Time: O(n) Space: (1))
class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I') {
                res += 1;
            } else if(s.charAt(i) == 'V') {
                res += 5;
                if(i > 0 && s.charAt(i - 1) == 'I')
                    res -= 2;
            } else if(s.charAt(i) == 'X') {
                res += 10;
                if(i > 0 && s.charAt(i - 1) == 'I')
                    res -= 2;
            } else if(s.charAt(i) == 'L') {
                res += 50;
                if(i > 0 && s.charAt(i - 1) == 'X')
                    res -= 20;
            } else if(s.charAt(i) == 'C') {
                res += 100;
                if(i > 0 && s.charAt(i - 1) == 'X')
                    res -= 20;
            } else if(s.charAt(i) == 'D') {
                res += 500;
                if(i > 0 && s.charAt(i - 1) == 'C')
                    res -= 200;
            } else if(s.charAt(i) == 'M') {
                res += 1000;
                if(i > 0 && s.charAt(i - 1) == 'C')
                    res -= 200;
            }
        }
        return res;
    }
}

//Left to Right With HashMap (Time: O(n) Space: (1))
class Solution {
    static Map<Character, Integer> romans = new HashMap<>();
    static {
        romans.put('M', 1000);
        romans.put('D', 500);
        romans.put('C', 100);
        romans.put('L', 50);
        romans.put('X', 10);
        romans.put('V', 5);
        romans.put('I', 1);
    }

    public int romanToInt(String s) {
        int res = 0;
        //int val = romans.get(s.charAt(0));
        //int next = 0;

        for(int i = 0; i < s.length(); i++) {
            int val = romans.get(s.charAt(i));
            int next = i + 1 < s.length() ? romans.get(s.charAt(i + 1)) : 0;

            if(val < next) {
                res += next - val;
                i++;
            } else {
                res += val;
            }
        }
        return res;
    }
}

//Left to Right With HashMap (Time: O(n) Space: O(1))
class Solution {
    static Map<String, Integer> romans = new HashMap<>();
    static {
        romans.put("M", 1000);
        romans.put("CM", 900);
        romans.put("D", 500);
        romans.put("CD", 400);
        romans.put("C", 100);
        romans.put("XC", 90);
        romans.put("L", 50);
        romans.put("XL", 40);
        romans.put("X", 10);
        romans.put("IX", 9);
        romans.put("V", 5);
        romans.put("IV", 4);
        romans.put("I", 1);
    }

    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            String roman = i + 1 < s.length() ? s.substring(i, i + 2) : s.substring(i, i + 1);
            if(romans.containsKey(roman)) {
                res += romans.get(roman);
                i++;
            } else {
                res += romans.get(s.substring(i, i + 1));
            }
        }
        return res;
    }
}

//Right to Left With HashMap (Time: O(n) Space: (1))
class Solution {
    static Map<Character, Integer> romans = new HashMap<>();
    static {
        romans.put('M', 1000);
        romans.put('D', 500);
        romans.put('C', 100);
        romans.put('L', 50);
        romans.put('X', 10);
        romans.put('V', 5);
        romans.put('I', 1);
    }

    public int romanToInt(String s) {
        int res = 0;
        int last = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            int roman = romans.get(s.charAt(i));
            if(roman < last)
                res -= roman;
            else
                res += roman;
            last = roman;
        }
        return res;
    }
}