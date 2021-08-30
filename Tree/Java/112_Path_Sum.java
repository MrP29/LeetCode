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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        
        targetSum -= root.val;
        if(root.left == null && root.right == null)
            return targetSum == 0;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}

//Iteration by LeetCode (Time: O(N) Space: O(N))
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        
        LinkedList<TreeNode> nodeStack = new LinkedList();
        LinkedList<Integer> sumStack = new LinkedList();
        
        nodeStack.add(root);
        sumStack.add(targetSum - root.val);
        
        TreeNode curNode;
        int curSum;
        while(!nodeStack.isEmpty()) {
            curNode = nodeStack.pollLast();
            curSum = sumStack.pollLast();
            if(curNode.left == null && curNode.right == null && curSum == 0)
                return true;
            
            if(curNode.left != null) {
                nodeStack.add(curNode.left);
                sumStack.add(curSum - curNode.left.val);
            }
            if(curNode.right != null) {
                nodeStack.add(curNode.right);
                sumStack.add(curSum - curNode.right.val);
            }
        }
        return false;
    }
}