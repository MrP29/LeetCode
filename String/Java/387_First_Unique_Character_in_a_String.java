//Track index (Time: O(n) Space: O(1))
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            int cIndex = s.charAt(i) - 'a';
            if(count[cIndex] == 0) {
                count[cIndex] = i + 1;
            }
            else if(count[cIndex] > 0)
                count[cIndex] = -1;
        }
        
        int minIndex = n + 1;
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0 && count[i] < minIndex)
                minIndex = count[i];
        }
        return minIndex == n + 1 ? -1 : minIndex - 1;
    }
}

//Track number of duplication (Time: O(n) Space: O(1))
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(count[c - 'a'] == 1)
                return i;
        }
        return -1;
    }
}

//Using indexOf of String Method (Time: O(n^2) Space: O(1))
class Solution {
    public int firstUniqChar(String s) {
        for(int i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i + 1); // s = "leetcode"  i = 4
            if(s.indexOf(ch) == i && s.lastIndexOf(ch) == i)
                return i;
        }
        return -1;
    }
}

//Hash Table(Time: O(n) Space: O(n))
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length;

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < n; i++) {
            if(count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}