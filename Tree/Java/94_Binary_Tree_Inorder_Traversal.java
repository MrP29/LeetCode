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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        
        if(root == null)
            return arr;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        
        while(!stack.isEmpty() || currNode != null) {
            if(currNode != null) {
                stack.push(currNode);
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

//Iteration (Time: O(n) Space: O(n))
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        
        if(root == null)
            return arr;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        
        while(!stack.isEmpty() || currNode != null) {
            while(currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            arr.add(currNode.val);
            currNode = currNode.right;
        }
        return arr;
    }
}

//Recursion (Time: O(n) Space: (n))
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return arr;
    }

    public void inorder(TreeNode root, List<Integer> arr) {
        if(root != null) {
            if(root.left != null) {
                inorder(root.left, arr);
            }
            arr.add(root.val);
            if(root.right != null) {
                inorder(root.right, arr);
            }
        }
    }
}