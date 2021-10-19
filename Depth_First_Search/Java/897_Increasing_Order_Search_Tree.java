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

//Iterative In-Order Traversal (Time: O(N) Space: O(H))
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newHead = new TreeNode();
        TreeNode curNode = newHead;
        
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                curNode.right = node;
                node.left = null;
                curNode = curNode.right;
                node = node.right;
            }
        }
        return newHead.right;
    }
}

//Recursive In-Order Traversal (Time: O(N) Space: O(H))
class Solution {
    TreeNode curNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode newHead = new TreeNode(-1, null, root);
        this.curNode = newHead;
        inorder(root);
        return newHead.right;
    }

    private void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        root.left = null;
        this.curNode.right = root;
        this.curNode = root;
        inorder(root.right);
    }
}