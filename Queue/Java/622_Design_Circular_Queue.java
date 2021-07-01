//Array (Time: O(1) Space: O(n))
class MyCircularQueue {
    private int[] cQueue;
    private int front;
    private int size;
    private int MAX_SIZE;
    
    public MyCircularQueue(int k) {
        cQueue = new int[k];
        front = 0;
        size = 0;
        MAX_SIZE = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        int last = (front + size) % MAX_SIZE;
        cQueue[last] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        front = (front + 1) % MAX_SIZE;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return cQueue[front];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        int last = (front + size - 1) % MAX_SIZE;
        return cQueue[last];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == MAX_SIZE;
    }
}

//Linked List (Time: O(1) Space: O(n))
//ReentranctLock code by LeetCode
class MyCircularQueue {
    private Node head;
    private Node tail;
    private int size;
    private int MAX_SIZE;
    private ReentrantLock queueLock = new ReentrantLock();

    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
    public MyCircularQueue(int k) {
        size = 0;
        MAX_SIZE = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        queueLock.lock();
        try {
            Node newNode = new Node(value);
            if(isEmpty()) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        } finally {
            queueLock.unlock();
        }
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        head = head.next;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return head.value;
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return tail.value;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == MAX_SIZE;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */