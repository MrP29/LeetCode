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
//Recursion (Time: O(N) Space: O(N))
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        if((left != null && right == null) || (left == null && right != null))
            return false;
        if(left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

//DFS Iteration (Time: O(N) Space: O(N))
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        
        while(!nodes.isEmpty() || leftNode != null || rightNode != null) {
            if(leftNode != null && rightNode != null) {
                if(leftNode.val != rightNode.val)
                    return false;
                nodes.push(leftNode.right);
                nodes.push(rightNode.left);
                leftNode = leftNode.left;
                rightNode = rightNode.right;
            } else {
                if(leftNode == null ^ rightNode == null)
                    return false;
                leftNode = nodes.pop();
                rightNode = nodes.pop();
            }
        }
        return true;
    }
}

//BFS Iteration (Time: O(N) Space: O(N))
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        
        queue.add(root.left);
        queue.add(root.right);
        
        while(!queue.isEmpty()) {
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            
            if(left == null && right == null)
                continue;
            
            if((left == null && right != null) || (left != null && right == null))
                return false;
            
            if(left.val != right.val)
                return false;
            
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}