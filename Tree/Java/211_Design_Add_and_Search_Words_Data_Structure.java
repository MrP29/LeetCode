//Using Trie Data Structure with Array (Time: O(N * 26^M) Space: O(M))
class WordDictionary {
    Node trie;
    
    public WordDictionary() {
        trie = new Node();
    }
    
    public void addWord(String word) {
        Node cur = trie;
        for(char c: word.toCharArray()) {
            if(cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return recurSearchHelp(trie, 0, word);
        //return iterSearchHelp(trie, word);
    }
    
    private boolean recurSearchHelp(Node cur, int index, String word) {
        if(cur == null)
            return false;
        
        if(index == word.length())
            return cur.isWord;
        
        char c = word.charAt(index);
        
        if(c != '.') {
            return recurSearchHelp(cur.children[c - 'a'], index + 1, word);
        } else {
            boolean found = false;
            for(int i = 0; !found && i < 26; i++) {
                if(cur.children[i] != null)
                    found = recurSearchHelp(cur.children[i], index + 1, word);
            }
            return found;
        }
    }

    private boolean iterSearchHelp(Node cur, String word) {
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(int j = 0; j < 26; j++) {
                    if(cur.children[j] != null && iterSearchHelp(cur.children[j], word.substring(i + 1)))
                        return true;
                }
                return false;
            } else if(cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
            } else {
                return false;
            }
        }
        return cur.isWord;
    }
}

class Node {
    Node[] children;
    boolean isWord = false;
    
    public Node() {
        children = new Node[26];
    }
}

//Using Trie Data Structure with Hash Map by LeetCode (Time: O(N * 26^M) Space: O(M))
class WordDictionary {
    Node trie;
    
    public WordDictionary() {
        trie = new Node();
    }
    
    public void addWord(String word) {
        Node cur = trie;
        
        for(char c: word.toCharArray()) {
            if(!cur.children.containsKey(c))
                cur.children.put(c, new Node());
            
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchWord(trie, word);
    }
    
    private boolean searchWord(Node node, String word) {
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.children.containsKey(c)) {
                if(c == '.') {
                    for(char x: node.children.keySet()) {
                        if(searchWord(node.children.get(x), word.substring(i + 1)))
                            return true;
                    }
                }
                return false;
            } else {
                node = node.children.get(c);
            }
        }
        return node.isWord;
    }
}

class Node {
    Map<Character, Node> children;
    boolean isWord;
    
    public Node() {
        children = new HashMap();
        isWord = false;
    }
}

//Using Hash Map by LeetCode (Time: O(N * M) Space: O(N * M)) - Inefficient
class WordDictionary {
    Map<Integer, Set<String>> d;

    /** Initialize your data structure here. */
    public WordDictionary() {
        d = new HashMap();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int m = word.length();
        if (!d.containsKey(m)) {
            d.put(m, new HashSet());
        }
        d.get(m).add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int m = word.length();
        if (d.containsKey(m)) {
            for (String w : d.get(m)) {
                int i = 0;
                while ((i < m) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
                    i++;
                }
                if (i == m) return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */