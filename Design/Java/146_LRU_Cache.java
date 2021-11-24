//Using Hash Map and Linked List (Time: O(1) Space: O(c))
class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node head, tail;
    int size;
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int k, int v){
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap();
        this.head = new Node(-1, -1);
        this.tail = new Node(-2, -2);
        size = 0;
        
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null)
            return -1;
        
        moveNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        
        if(node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            addNode(node);
            if(size > capacity) {
                cache.remove(head.next.key);
                removeNode(head.next);
            }
        } else {
            moveNode(node);
            node.val = value;
        }
    }
    
    public void addNode(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        
        tail.prev.next = node;
        tail.prev = node;
        
        size++;
    }
    
    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;
    }
    
    public void moveNode(Node node) {
        removeNode(node);
        addNode(node);
    }
}

//Ordered Dictionary with LinkedHashMap by LeetCode (Time: O(1) Space: O(c))
class LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
*/