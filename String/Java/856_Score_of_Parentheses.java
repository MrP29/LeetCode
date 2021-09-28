//Using Stack (Time: O(N) Space: O(N))
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }
}

//Count Cores by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0;
        int bal = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if(s.charAt(i - 1) == '(')
                    ans += 1 << bal;
            }
        }
        
        return ans;
    }
}

//Divide and Conquer by LeetCode (Time: O(N^2) Space: O(N))
class Solution {
    public int scoreOfParentheses(String s) {
        return score(s, 0, s.length());
    }
    
    private int score(String s, int i, int j) {
        int ans = 0;
        int bal = 0;
        
        for(int k = i; k < j; k++) {
            bal += s.charAt(k) == '(' ? 1 : -1;
            if(bal == 0) {
                if(k - i == 1)
                    ans++;
                else
                    ans += 2 * score(s, i + 1, k);
                i = k + 1;
            }
        }
        return ans;
    }
}

