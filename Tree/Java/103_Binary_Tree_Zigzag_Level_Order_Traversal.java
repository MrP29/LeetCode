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
//DFS Recursion (Time: O(N) Space: O(logN))
class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        ans = new ArrayList();
        if(root == null)
            return ans;
        
        ans.add(new ArrayList());
        ans.get(0).add(root.val);
        
        zigzagLevelOrder(root.left, 1);
        zigzagLevelOrder(root.right, 1);
        
        zigzagArray();
        return ans;
    }
    
    private void zigzagLevelOrder(TreeNode root, int height) {
        if(root == null)
            return;
        
        if(ans.size() <= height)
            ans.add(new ArrayList());
        
        ans.get(height).add(root.val);
        
        zigzagLevelOrder(root.left, height + 1);
        zigzagLevelOrder(root.right, height + 1);
        
        return;
    }
    
    private void zigzagArray() {
        for(int i = 1; i < ans.size(); i += 2)
            Collections.reverse(ans.get(i));
    }
}

//BFS Iteration (Time: O(N) Space: O(N))
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null)
            return ans;
        
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        
        LinkedList<Integer> level = new LinkedList();
        boolean order_left = true;
        
        while(queue.size() > 0) {
            TreeNode curNode = queue.pollFirst();
            if(curNode != null) {
                if(order_left)
                    level.addLast(curNode.val);
                else
                    level.addFirst(curNode.val);
                
                if(curNode.left != null)
                    queue.addLast(curNode.left);
                if(curNode.right != null)
                    queue.addLast(curNode.right);
            } else {
                ans.add(level);
                level = new LinkedList();
                if(queue.size() > 0)
                    queue.addLast(null);
                order_left = !order_left;
            }
        }
        return ans;
    }
}