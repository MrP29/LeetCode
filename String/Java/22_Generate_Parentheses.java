//Recursive Backtracking (Time: O(4^N / sqrt(N) Space: O(4^N / sqrt(N)))
class Solution {
    List<String> res;
    
    public List<String> generateParenthesis(int n) {
        res = new ArrayList();
        
        generate(0, 0, n, "");
        return res;
    }
    
    private void generate(int open, int close, int n, String str) {
        if(open == n && close == n)
            this.res.add(str);
        
        if(open < n)
            generate(open + 1, close, n, str + "(");
        
        if(close < open)
            generate(open, close + 1, n, str + ")");
    }
}

//Brute Force
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        res.add("");
        
        for(int i = 1; i <= n; i++) {
            Set<String> duplicate = new HashSet();

            for(String str: res) {
                int length = str.length();
                for(int j = 0; j <= length; j++) {
                    String parentheses = str.substring(0, j) + "()" + str.substring(j, length);
                    duplicate.add(parentheses);
                }
            }
            
            res.clear();
            res.addAll(duplicate);
        }
        
        return res;
    }
}

//Closure Number by LeetCode (Time: O(4^N / sqrt(N) Space: O(4^N / sqrt(N)))
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        if(n == 0) {
            res.add("");
        } else {
            for(int c = 0; c < n; c++) {
                for(String left: generateParenthesis(c)) {
                    for(String right: generateParenthesis(n - 1 - c)) {
                        res.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return res;
    }
}

//Brute Force by LeetCode (Time: O(2^2N * N) Space: O(2^2N * N))
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        generateAll(new char[2 * n], 0, res);
        return res;
    }
    
    private void generateAll(char[] current, int pos, List<String> res) {
        if(pos == current.length) {
            if(valid(current))
                res.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, res);
            current[pos] = ')';
            generateAll(current, pos + 1, res);
        }
    }
    
    private boolean valid(char[] current) {
        int balance = 0;
        for(char c: current) {
            balance += c == '(' ? 1 : -1;
            if(balance < 0)
                return false;
        }
        return balance == 0;
    }
}