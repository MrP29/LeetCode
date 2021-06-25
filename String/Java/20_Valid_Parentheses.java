//With HashMap (Time: O(n) Space: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');
        
        for(char c: s.toCharArray()) {
            if(map.containsKey(c))
                stack.push(map.get(c));
            else if(stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}

//Without HashMap (Time: O(n) Space: O(n))
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if(c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else if(stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}