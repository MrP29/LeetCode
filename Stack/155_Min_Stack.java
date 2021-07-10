class MinStack {
    List<Integer> stack;
    List<Integer> minIndex;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minIndex = new ArrayList<>();
    }
    
    public void push(int x) {
        stack.add(x);
        if(minIndex.size() == 0) {
            minIndex.add(0);
        } else if(x < stack.get(minIndex.get(minIndex.size() - 1))) {
            minIndex.add(stack.size() - 1);
        }
    }
    
    public void pop() {
        if(minIndex.get(minIndex.size() - 1) == stack.size() - 1) {
            minIndex.remove(minIndex.size() - 1);
        }
        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return stack.get(minIndex.get(minIndex.size() - 1));
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