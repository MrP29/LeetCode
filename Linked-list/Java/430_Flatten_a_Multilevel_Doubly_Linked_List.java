/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
//Iteration (Time: O(N) Space: O(N))
class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return null;
        
        Node dummy = new Node(-1, null, head, null);
        Node cur;
        Node prev = dummy;
        
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()) {
            cur = stack.pop();
            prev.next = cur;
            cur.prev = prev;
            
            if(cur.next != null)
                stack.push(cur.next);
            if(cur.child != null)
                stack.push(cur.child);
            cur.child = null;
            prev = cur;
        }
        dummy.next.prev = null;
        return dummy.next;
    }
}

//Recursion (Time: O(N) Space: O(N))
class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return null;
        
        Node dummy = new Node(-1, null, head, null);
        flatHelp(dummy, head);

        dummy.next.prev = null;
        return dummy.next;
    }
    
    private Node flatHelp(Node prev, Node cur) {
        if(cur == null)
            return prev;

        Node next = cur.next;
        cur.prev = prev;
        prev.next = cur;

        Node tail = flatHelp(cur, cur.child);
        cur.child = null;

        return flatHelp(tail, next);
    }
}

//Iteration (Time: O(N) Space: O(N))
class Solution {
    public Node flatten(Node head) {     
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null || !stack.isEmpty()) {
            if(cur.child != null) {
                if(cur.next != null)
                    stack.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                cur = cur.next;
            } else {
                if(cur.next != null) {
                    cur = cur.next;
                } else {
                    if(!stack.isEmpty()) {
                        Node next = stack.pop();
                        cur.next = next;
                        next.prev = cur;
                        cur = cur.next;
                    } else {
                        return head;
                    }
                }
            }
        }
        return head;
    }
}