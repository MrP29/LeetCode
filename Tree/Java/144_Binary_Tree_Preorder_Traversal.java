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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        
        if(root == null)
            return arr;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode currNode = st.pop();
            
            arr.add(currNode.val);
            
            if(currNode.right != null)
                st.push(currNode.right);
            if(currNode.left != null)
                st.push(currNode.left);
        }
        return arr;
    }
}

//Morris traversal (Time: O(n) Space: O(n))
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();

        TreeNode node = root;
        while(node != null) {
            if(node.left == null) {
                output.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                while((predecessor.right != null) && (predecessor.right != nude)) {
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null) {
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }
}