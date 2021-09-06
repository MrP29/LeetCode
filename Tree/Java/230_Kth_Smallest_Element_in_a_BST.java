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
//Iteration with Stack (Time: O(N) Space: O(N)))
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();

        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(--k == 0)
                    return root.val;
                root = root.right;
            }
        }
        return -1;
    }
}

//Recursion by LeetCode (Time: O(N) Space: O(N))
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = inorder(root, new ArrayList<Integer>());
        return arr.get(k - 1);
    }
    
    private List<Integer> inorder(TreeNode root, List<Integer> arr) {
        if(root == null)
            return arr;
        
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}