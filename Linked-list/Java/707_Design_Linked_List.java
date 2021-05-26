//Singly Linked List without the Sentinel node (Time: O(n) Space: (1))
class MyLinkedList {
    int size;
    MyNode head;
    
    class MyNode {
        int val;
        MyNode next;
        
        public MyNode(int val) {
            this.val = val;
            this.next = null;
        }
        
        public MyNode(int val, MyNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size)
            return -1;

        MyNode cur = head;
        for(int i = 0; i < index; i++)
            cur = cur.next;
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size)
            return;
        
        if(index == 0) {
            MyNode cur = new MyNode(val, this.head);
            this.head = cur;
        } else {
            MyNode cur = head;
            for(int i = 0; i < index - 1; i++)
                cur = cur.next;
            cur.next = new MyNode(val, cur.next);
        }
        this.size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size)
            return;
        
        if(index == 0) {
            head = head.next;
        } else {
            MyNode cur = head;
            for(int i = 0; i < index - 1; i++)
                cur = cur.next;
            cur.next = cur.next.next;
        }
        this.size--;
    }
}

//Doubly Linked List without the Sentinel nodes (Time: O(1) Space: O(1))
class MyLinkedList {
    int size;
    MyNode head;
    MyNode tail;
    
    class MyNode {
        int val;
        MyNode next;
        MyNode prev;
        
        public MyNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
        
        public MyNode(int val, MyNode next, MyNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size)
            return -1;

        MyNode cur = head;
        for(int i = 0; i < index; i++)
            cur = cur.next;
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size)
            return;
        
        if(size == 0) {
            MyNode cur = new MyNode(val);
            this.head = cur;
            this.tail = cur;
        } else if(index == 0) {
            MyNode cur = new MyNode(val, this.head, null);
            this.head.prev = cur;
            this.head = cur;
        } else if (index == size) {
            MyNode cur = new MyNode(val, null, this.tail);
            this.tail.next = cur;
            this.tail = cur;
        } else {
            MyNode cur = head;
            for(int i = 0; i < index - 1; i++)
                cur = cur.next;
            MyNode next = cur.next;
            MyNode newNode = new MyNode(val, next, cur);
            cur.next = newNode;
            next.prev = newNode;
        }
        this.size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size)
            return;
        
        if(size == 1) {
            this.head = null;
            this.tail = null;
        } else if(index == 0) {
            head = head.next;
            head.prev = null;
        } else if(index + 1 == size) {
            tail = tail.prev;
            tail.next = null;
        } else {
            MyNode cur = head;
            for(int i = 0; i < index - 1; i++)
                cur = cur.next;
            cur.next = cur.next.next;
            cur.next.prev = cur;
        }
        this.size--;
    }
}