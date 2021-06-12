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
//Recursion (Time: O(n) Space: O(n))
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

//Iteration (Time: O(n) Space: O(n))
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.add(root);
        depth.add(1);

        int maxDepth = 0;
        int curDepth = 0;
        while(!stack.isEmpty()) {
            root = stack.pop();
            curDepth = depth.pop();
            if(root != null) {
                maxDepth = Math.max(maxDepth, curDepth);
                stack.push(root.left);
                stack.push(root.right);
                depth.push(curDepth + 1);
                depth.push(curDepth + 1);
            }
        }
        return maxDepth;
    }
}