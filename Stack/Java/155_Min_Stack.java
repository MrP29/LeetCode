//Double Stack (Time: O(1) Space: O(N))
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        stack.add(x);
        if(min.isEmpty() || x <= min.peek()) {
            min.add(x);
        }
    }
    
    public void pop() {
        if(min.peek() == stack.peek()) {
            min.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

//Space Optimized Two Stacks By LeetCode (Time: O(1) Space: O(N))
class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<int[]> minStack = new Stack<>();
    
    public MinStack() { }
    
    public void push(int x) {
        stack.push(x);
        
        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[]{x, 1});
        }
        
        else if (x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }
    
    
    public void pop() {
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }

        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }

        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
    }
}

//Single Stack (Time: O(1) Space: O(N))
class MinStack {
    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        int minimum = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek()[1];
        stack.push(x, Math.min(x, minimum));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */