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
//Depth(Top-down recursion) (Time: O(nlogn) Space: O(n))
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(!isBalanced(root.left) || !isBalanced(root.right))
            return false;
        
        return Math.abs(depth(root.left) - depth(root.right)) <= 1
    }
    
    private int depth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

//Height(Bottom-up recursion) by LeetCode (Time: O(n) Space: O(n))
final class TreeInfo {
  public final int height;
  public final boolean balanced;

  public TreeInfo(int height, boolean balanced) {
    this.height = height;
    this.balanced = balanced;
  }
}

class Solution {
  public boolean isBalanced(TreeNode root) {
    return isBalancedTreeHelper(root).balanced;
  }

  private TreeInfo isBalancedTreeHelper(TreeNode root) {
    if (root == null) {
      return new TreeInfo(-1, true);
    }

    TreeInfo left = isBalancedTreeHelper(root.left);
    if (!left.balanced) {
      return new TreeInfo(-1, false);
    }
    
    TreeInfo right = isBalancedTreeHelper(root.right);
    if (!right.balanced) {
      return new TreeInfo(-1, false);
    }

    if (Math.abs(left.height - right.height) < 2) {
      return new TreeInfo(Math.max(left.height, right.height) + 1, true);
    }
    return new TreeInfo(-1, false);
  }
}