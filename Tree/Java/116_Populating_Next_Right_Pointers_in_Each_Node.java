/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
//Using Queue with Delimiter (Time: O(N) Space: O(N))
class Solution {
    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList();
        
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty() && queue.peek() != null) {
            Node curNode = queue.poll();
            curNode.next = queue.peek();
            
            if(curNode.left != null) {
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
            
            if(curNode.next == null) {
                queue.poll();
                queue.add(null);
            }
        }
        return root;
    }
}

//Using Queue by LeetCode (Time: O(N) Space: O(N))
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                if(i < size - 1)
                    curNode.next = queue.peek();
                if(curNode.left != null) {
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                }
            }
        }
        return root;
    }
}

//by LeetCode (Time: O(N) Space: (1))
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        Node leftmost = root;
        
        while(leftmost.left != null) {
            Node head = leftmost;
            
            while(head != null) {
                head.left.next = head.right;
                
                if(head.next != null)
                    head.right.next = head.next.left;
                
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}