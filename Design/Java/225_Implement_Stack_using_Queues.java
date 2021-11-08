//One Queue with O(N) Pop (Time: O(N) Space: O(1))
class MyStack {
    Queue<Integer> queue;
    int top;
    
    public MyStack() {
        queue = new LinkedList();
    }
    
    public void push(int x) {
        queue.offer(x);
        top = x;
    }
    
    public int pop() {
        for(int i = 0; i < queue.size() - 1; i++) {
            top = queue.poll();
            queue.offer(top);
            
        }
        return queue.poll();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}


//Two Queues with O(N) Pop (Time: O(N) Space: O(N))
class MyStack {
    Queue<Integer> queue;
    int last;
    
    public MyStack() {
        queue = new LinkedList();
    }
    
    public void push(int x) {
        last = x;
        queue.offer(x);
    }
    
    public int pop() {
        Queue<Integer> temp = new LinkedList();
        while(queue.size() > 1) {
            last = queue.poll();
            temp.offer(last);
        }

        int pop = queue.poll();
        queue = temp;
        return pop;
    }
    
    public int top() {
        return last;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

//Two Queues with O(N) Push (Time: O(N) Space: O(N))
class MyStack {
    Queue<Integer> queue;
    
    public MyStack() {
        queue = new LinkedList();
    }
    
    public void push(int x) {
        Queue<Integer> temp = new LinkedList();
        temp.offer(x);
        while(!queue.isEmpty())
            temp.offer(queue.poll());
        queue = temp;
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */