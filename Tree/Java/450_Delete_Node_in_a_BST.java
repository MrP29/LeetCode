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
//Iteration (Time: O(H) Space: O(1))
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode rootP = new TreeNode(0, null, root);
        TreeNode parent = rootP;
        TreeNode node = root;
        
        while(node != null) {
            if(node.val == key)
                break;
            
            parent = node;
            if(node.val > key)
                node = node.left;
            else
                node = node.right;
        }
        
        if(node == null)
            return root;
        
        if(node.left != null && node.right != null) {
            TreeNode leftMost = node.right;
            TreeNode mostParent = null;
            while(leftMost.left != null) {
                mostParent = leftMost;
                leftMost = leftMost.left;
            }

            if(mostParent != null)
                mostParent.left = leftMost.right;
            
            leftMost.left = node.left;
            if(leftMost != node.right)
                leftMost.right = node.right;
            
            if(parent.val > key)
                parent.left = leftMost;
            else
                parent.right = leftMost;
        } else {
            if(parent.val > key)
                parent.left = node.left != null ? node.left : node.right;
            else
                parent.right = node.left != null ? node.left : node.right;
        }

        return rootP.right;
    }
}

//Recursion by LeetCode (Time: O(H) Space: O(H))
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    
    private int successor(TreeNode root) {
        root = root.right;
        while(root.left != null)
            root = root.left;
        return root.val;
    }
    
    private int predecessor(TreeNode root) {
        root = root.left;
        while(root.right != null)
            root = root.right;
        return root.val;
    }
}