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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        
        if(root == null)
            return arr;
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode currNode = root;
        
        while(!st.isEmpty() || currNode != null) {
            if(currNode != null) {
                st.push(currNode);
                currNode = currNode.left;
            } else {
                currNode = st.pop();
                arr.add(currNode.val);
                currNode = currNode.right;
            }
        }
        return arr;
    }
}