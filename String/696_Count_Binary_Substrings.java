//Counting (Time: O(N) Space: O(1))
class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prev = 0;
        int cur = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i - 1) == s.charAt(i)) {
                cur++;
            } else {
                count += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }
        return count + Math.min(prev, cur);
    }
}

//Counting with Aux Array (Time: O(N) Space: O(N))
class Solution {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i - 1) != s.charAt(i))
                groups[++t] = 1;
            else
                groups[t]++;
        }
        
        int count = 0;
        for(int i = 0; i < t; i++) 
            count += Math.min(groups[i], groups[i + 1]);
        
        return count;
    }
}
