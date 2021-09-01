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
//Recursion with Hash Map (Time: O(N) Space: O(N))
class Solution {
    int postIndex;
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> indexMap = new HashMap();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postIndex = postorder.length - 1;
        
        for(int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i], i);
        
        return helper(0, inorder.length - 1);
    }
    
    private TreeNode helper(int indexLeft, int indexRight) {
        if(indexLeft > indexRight)
            return null;
        
        int val = postorder[postIndex];
        TreeNode root = new TreeNode(val);
        
        int index = indexMap.get(val);
        
        postIndex--;
        
        root.right = helper(index + 1, indexRight);
        root.left = helper(indexLeft, index - 1);
        return root;
    }
}