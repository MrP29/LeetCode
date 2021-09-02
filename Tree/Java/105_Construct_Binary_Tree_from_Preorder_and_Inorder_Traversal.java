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
    int[] preorder;
    int[] inorder;
    int preorderIdx;
    Map<Integer, Integer> inorderMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        preorderIdx = 0;
        inorderMap = new HashMap();
        
        for(int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        
        return helper(0, preorder.length - 1);
    }
    
    private TreeNode helper(int leftIdx, int rightIdx) {
        if(leftIdx > rightIdx)
            return null;
        
        TreeNode head = new TreeNode(preorder[preorderIdx++]);
        
        int index = inorderMap.get(head.val);
        
        head.left = helper(leftIdx, index - 1);
        head.right = helper(index + 1, rightIdx);
        return head;
    }
}