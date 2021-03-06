//Reverse Pop (Time: O(N) Space: O(N))
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int first;
    
    public MyQueue() {
        st1 = new Stack();
        st2 = new Stack();
    }
    
    public void push(int x) {
        if(st1.isEmpty())
            first = x;
        st1.push(x);
    }
    
    public int pop() {
        if(st2.isEmpty()) {
            while(!st1.isEmpty())
                st2.push(st1.pop());
        }
        return st2.pop();
    }
    
    public int peek() {
        if(!st2.isEmpty())
            return st2.peek();
        return first;
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

//Reverse Push (Time: O(N) Space: O(N))
class MyQueue {
    Stack<Integer> st;
    int first;

    public MyQueue() {
        st = new Stack();
    }

    public void push(int x) {
        if(st.isEmpty())
            first = x;

        Stack<Integer> reverse = new Stack();

        while(!st.isEmpty())
            reverse.push(st.pop());

        st.push(x);
        while(!reverse.isEmpty())
            st.push(reverse.pop());
    }

    public int pop() {
        return st.pop();
    }

    public int peek() {
        return st.peek();
    }

    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */