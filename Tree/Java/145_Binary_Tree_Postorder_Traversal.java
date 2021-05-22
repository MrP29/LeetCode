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

//Iteration (Time: O(n) Space: O(n))
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if(root == null)
            return arr;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        Stack<Integer> out = new Stack<>();
        
        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            out.push(currNode.val);
            
            if(currNode.left != null)
                stack.push(currNode.left);
            if(currNode.right != null)
                stack.push(currNode.right);
        }
        while(!out.isEmpty())
            arr.add(out.pop());
        
        return arr;
    }
}