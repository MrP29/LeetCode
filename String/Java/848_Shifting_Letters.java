//Using Char Array From Right To Left (Time: O(N) Space: O(N))
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] ch = s.toCharArray();
        int shift = 0;
        
        for(int i = ch.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            ch[i] = (char) (((ch[i] - 'a') + shift) % 26 + 'a');
        }
        return String.valueOf(ch);
    }
}

//Using StringBuilder From Left To Right by LeetCode (Time: O(N) Space: O(N))
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder shifted = new StringBuilder();
        
        int shift = 0;
        for(int n: shifts)
            shift = (shift + n) % 26;
        
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            shifted.append((char) ((index + shift) % 26 + 'a'));
            shift = Math.floorMod(shift - shifts[i], 26);
        }
        return shifted.toString();
    }
}