//Binary Search (Time: O(NlogN + MlogN) Space: O(logN))
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList();
        int start = 0;

        for(int i = 0; i < searchWord.length(); i++) {
            List<String> list = new ArrayList();
            String target = searchWord.substring(0, i + 1);
            start = binarySearch(products, start, target);
            
            for(int j = start; j < Math.min(start + 3, products.length); j++) {
                if(products[j].length() < i + 1 || !products[j].substring(0, i + 1).equals(target))
                    break;
                list.add(products[j]);
            }
            
            res.add(list);
        }
        return res;
    }
    
    private int binarySearch(String[] products, int start, String target) {
        int min = start, max = products.length - 1, mid;
        
        while(min < max) {
            mid = (max - min) / 2 + min;
            
            if(products[mid].compareTo(target) >= 0)
                max = mid;
            else
                min = mid + 1;
        }
        
        return min;
    }
}

//Binary Search by LeetCode (Time: O(NlogN + MlogN) Space: O(1))
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList();
        int start = 0, bsStart = 0, n = products.length;
        String prefix = new String();
        
        for(char c: searchWord.toCharArray()) {
            prefix += c;
            start = binarySearch(products, bsStart, prefix);
            
            List<String> list = new ArrayList();
            for(int i = start; i < Math.min(start + 3, n); i++) {
                if(products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                list.add(products[i]);
            }
            bsStart = start;
            res.add(list);
        }
        return res;
    }
    
    private int binarySearch(String[] products, int start, String target) {
        int min = start;
        int max = products.length - 1;
        while(min < max) {
            int mid = (max - min) / 2 + min;
            if(products[mid].compareTo(target) >= 0)
                max = mid;
            else
                min = mid + 1;
        }
        return min;
    }
}

//Binary Search with Two Pointers by LeetCode Discuss (Time: O(NlogN + MlogN) Space: O(1))
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        
        int start = 0, end = products.length - 1;
        String startPrefix = new String();
        String endPrefix = new String();
        
        for(char c: searchWord.toCharArray()) {
            startPrefix += c;
            endPrefix += (char)(c + 1);

            start = binarySearch(products, start, end, startPrefix);
            end = binarySearch(products, start, end, endPrefix);

            List<String> list = new ArrayList();
            for(int i = start; i < Math.min(start + 3, end + 1); i++) {
                if(products[i].length() < startPrefix.length() || !products[i].substring(0, startPrefix.length()).equals(startPrefix))
                    break;
                list.add(products[i]);
            }
            
            res.add(list);
            endPrefix = startPrefix;
        }
        return res;
    }
    
    private int binarySearch(String[] products, int s, int e, String target) {
        int min = s, max = e, mid;
        
        while(min < max) {
            mid = (max - min) / 2 + min;
            
            if(products[mid].compareTo(target) >= 0)
                max = mid;  
            else
                min = mid + 1;
        }
        
        return min;
    }
}

//DFS with Trie by LeetCode (Time: O(M) Space: O(N))
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> res = new ArrayList();
        
        for(String str: products)
            trie.insert(str);
        
        for(int i = 0; i < searchWord.length(); i++)
            res.add(trie.getWordsStartingWith(searchWord.substring(0, i + 1)));
        
        return res;
    }
}

class Trie {
    class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    };
    Node Root, cur;
    List<String> resBuffer;
    
    public Trie() {
        Root = new Node();
    }
    
    public void insert(String s) {
        cur = Root;
        for(char c: s.toCharArray()) {
            if(cur.children.get(c - 'a') == null)
                cur.children.set(c - 'a', new Node());
            cur = cur.children.get(c - 'a');
        }
        
        cur.isWord = true;
    }
    
    public List<String> getWordsStartingWith(String prefix) {
        cur = Root;
        resBuffer = new ArrayList();
        for(char c: prefix.toCharArray()) {
            if(cur.children.get(c - 'a') == null)
                return resBuffer;
            cur = cur.children.get(c - 'a');
        }
        dfsWithPrefix(cur, prefix);
        return resBuffer;
    }
    
    private void dfsWithPrefix(Node cur, String word) {
        if(resBuffer.size() == 3)
            return;
        if(cur.isWord)
            resBuffer.add(word);
        
        for(char c = 'a'; c <= 'z'; c++) {
            if(cur.children.get(c - 'a') != null)
                dfsWithPrefix(cur.children.get(c - 'a'), word + c);
        }
    }
}
