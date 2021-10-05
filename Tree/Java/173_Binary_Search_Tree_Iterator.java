/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Iterative Controlled Stack (Time: Avg O(1) Space: O(N)) 
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack();
        inorder(root);
    }

    private void inorder(TreeNode root) {
        while(root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode cur = this.stack.pop();

        if(cur.right != null)
            inorder(cur.right);

        return cur.val;
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}

//Iterative Inorder with Queue (Time: O(N) Space: O(N))
class BSTIterator {
    Queue<Integer> queue = new LinkedList();
    
    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                queue.add(cur.val);
                cur = cur.right;
            }
        }
    }
    
    public int next() {
        return queue.remove();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

//Recursive Inorder with Array (Time: O(N) Space: O(N))
class BSTIterator {
    List<Integer> list;
    int index;
    
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList();
        this.index = -1;
        
        inorder(root);
    }
    
    private void inorder(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root.left);
        this.list.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        return this.list.get(++this.index);
    }
    
    public boolean hasNext() {
        return this.index + 1 < this.list.size();
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */