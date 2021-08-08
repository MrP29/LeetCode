//Hash Table (Time: O(N) Space: O(N))
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int begin = 0;
        int end = 0;
        int longest = 0;
        Set<Character> set = new HashSet<>();
        while(end < c.length) {
            if(set.contains(c[end])) {
                longest = Math.max(longest, end - begin);
                while(c[begin] != c[end]) {
                    set.remove(c[begin]);
                    begin++;
                }
                begin++;
            }
            set.add(c[end]);
            end++;
        }
        return Math.max(longest, end - begin);
    }
}

//Array with Counting (Time: O(N) Space: O(1))
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int begin = 0;
        int end = 0;
        int longest = 0;
        while(end < s.length()) {
            char endC = s.charAt(end);
            chars[endC]++;

            while(chars[endC] > 1) {
                char oldC = s.charAt(begin);
                chars[oldC]--;
                begin++;
            }
            longest = Math.max(longest, end - right + 1);
            end++;
        }
        return longest;
    }
}

//Array with Mapping (Time: O(N) Space: O(1)))
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[128];

        int begin = 0;
        int end = 0;
        int longest = 0;
        while(end < s.length()) {
            char endC = s.charAt(end);
            Integer index = chars[endC];
            if(index != null && index >= begin && index < end)
                begin = index + 1;

            longest = Math.max(longest, end - begin + 1);
            chars[endC] = end;
            end++;
        }
        return longest;
    }
}