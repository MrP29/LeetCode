//Using StringBuilder (Time: O(n) Space: O(n))
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        
        StringBuilder reversed = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            reversed.append(" ");
        }
        return reversed.toString().trim();
    }
}

//Using Array Reverse (Time: O(n) Space: O(n))
class Solution {
    public String reversWords(String s) {
        String str = s.trim();
        List<String> words = Arrays.asList(str.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}

//Using Deque by LeetCode (Time: O(n) Space: O(n))
class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;

        while(left <= right && s.charAt(left) == ' ')
            left++;

        while(left <= right && s.charAt(right) == ' ')
            right--;

        Deque<String> d = new ArrayDeque();
        StringBuilder word = new StringBuilder();

        while(left <= right) {
            char c = s.charAt(left);

            if((word.length() != 0) && (c == ' ')) {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}