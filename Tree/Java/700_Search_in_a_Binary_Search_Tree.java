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
//Iteration (Time: O(H) Space: O(1)) Where H is height of the binary tree
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }
}

//Recursion (Time: O(H) Space: O(H))
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)
            return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}