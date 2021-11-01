//Using Stack (Time: O(N) Space: O(N))
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        
        for(String token: tokens) {
            if(!"+-*/".contains(token))
                st.push(Integer.valueOf(token));
            else if(token.equals("+"))
                st.push(st.pop() + st.pop());
            else if(token.equals("-"))
                st.push(-st.pop() + st.pop());
            else if(token.equals("*"))
                st.push(st.pop() * st.pop());
            else if(token.equals("/"))
                st.push((int)((1.0 / st.pop()) * st.pop()));
        }
        return st.pop();
    }
}

//Using Stack with lambda functionality by LeetCode (Time: O(N) Space: O(N))
class Solution {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap();
    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> -a + b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> (int)((1.0 / a) * b));
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        
        for(String token: tokens) {
            if(!OPERATIONS.containsKey(token)) {
                st.push(Integer.valueOf(token));
                continue;
            }
            
            BiFunction<Integer, Integer, Integer> operation;
            operation = OPERATIONS.get(token);
            st.push(operation.apply(st.pop(), st.pop()));
        }
        return st.pop();
    }
}