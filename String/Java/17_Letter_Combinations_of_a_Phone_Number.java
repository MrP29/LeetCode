//Iteration with HashMap (Time: O(4^N) Space: O(1))
class Solution {
    static Map<Character, String> keyPads = new HashMap<>();
    static {
        keyPads.put('2', "abc");
        keyPads.put('3', "def");
        keyPads.put('4', "ghi");
        keyPads.put('5', "jkl");
        keyPads.put('6', "mno");
        keyPads.put('7', "pqrs");
        keyPads.put('8', "tuv");
        keyPads.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<String>();
        
        List<String> comb = new ArrayList<>();
        comb.add("");
        char[] digit = digits.toCharArray();
        
        for(int i = 0; i < digit.length; i++) {
            char key = digit[i];
            char[] ch = keyPads.get(key).toCharArray();
            int keyLength = ch.length;
            int combSize = comb.size();
            
            for(int j = 0; j < combSize; j++) {
                for(int k = 0; k < keyLength; k++) {
                    comb.add(comb.get(j) + ch[k]);
                }
            }
            comb = comb.subList(combSize, comb.size());
        }
        return comb;
    }
}

//Iteration with Array (Time: O(4^N) Space: O(1))
class Solution {
    static Character[][] keyPads = new char{[0], [0], [a, b, c], [d, e, f], [g, h, i], [j, k, l],
                                            [m, n, o], [p, q, r, s], [t, u, v], [w, x, y, z]};
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<String>();
        
        List<String> comb = new ArrayList<>();
        char[] digit = digits.toCharArray();
        
        for(int i = 0; i < digit.length; i++) {
            char key = digit[i];
            char[] ch = keyPads.get(key).toCharArray();
            int keyLength = ch.length;
            int combSize = comb.size();
            
            for(int j = 0; j < combSize; j++) {
                for(int k = 0; k < keyLength; k++) {
                    comb.add(comb.get(j) + ch[k]);
                }
            }
            comb = comb.subList(combSize, comb.size());
        }
        return comb;
    }
}

//Backtracking Recursion by LeetCode (Time: O(4^N) Space: O(N))
class Solution {
    private List<String> comb = new ArrayList();
    private Map<Character, String> keyPads = Map.of('2', "abc", '3', "def",
                                                   '4', "ghi", '5', "jkl",
                                                   '6', "mno", '7', "pqrs",
                                                   '8', "tuv", '9', "wxyz");
    private String phoneDigits;
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return comb;
        
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return comb;
    }
    
    private void backtrack(int index, StringBuilder path) {
        if(path.length() == phoneDigits.length()) {
            comb.add(path.toString());
            return;
        }
        
        String possibleLetters = keyPads.get(phoneDigits.charAt(index));
        for(char letter: possibleLetters.toCharArray()) {
            path.append(letter);
            backtrack(index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}


