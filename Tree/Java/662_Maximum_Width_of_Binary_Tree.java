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
//BFS (Time: O(N) Space: O(N))
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.offer(null);
        int maxWidth = 0;
        
        Pair<TreeNode, Integer> leftMost = null;
        Pair<TreeNode, Integer> curPair = new Pair<>(root, 0);

        while(!queue.isEmpty() || curPair != null) {   
            if(curPair == null) {
                queue.offer(null);
                leftMost = null;
            } else {
                if(leftMost == null)
                    leftMost = curPair;

                TreeNode curNode = curPair.getKey();
                if(curNode.left != null)
                    queue.offer(new Pair<>(curNode.left, curPair.getValue() * 2));
                
                if(curNode.right != null)
                    queue.offer(new Pair<>(curNode.right, curPair.getValue() * 2 + 1));
                
                maxWidth = Math.max(maxWidth, curPair.getValue() - leftMost.getValue() + 1);
            }
            curPair = queue.poll();
        }
        
        return maxWidth;
    }
}

//BFS by LeetCode (Time: O(N) Space: O(N))
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int maxWidth = 0;
        
        queue.offer(new Pair<>(root, 0));
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> leftMost = queue.peek();
            
            int levelSize = queue.size();
            Pair<TreeNode, Integer> curPair = null;
            for(int i = 0; i < levelSize; i++) {
                curPair = queue.poll();
                TreeNode node = curPair.getKey();
                if(node.left != null)
                    queue.offer(new Pair<>(node.left, curPair.getValue() * 2));
                if(node.right != null)
                    queue.offer(new Pair<>(node.right, curPair.getValue() * 2 + 1));
            }
            
            maxWidth = Math.max(maxWidth, curPair.getValue() - leftMost.getValue() + 1);           
        }
        
        return maxWidth;
        
    }
}

//DFS by LeetCode (Time: O(N) Space: O(N))
class Solution {
    int maxWidth = 0;
    Map<Integer, Integer> firstColIndex;
    
    public int widthOfBinaryTree(TreeNode root) {
        this.firstColIndex = new HashMap<>();
        dfs(root, 0, 0);
        return this.maxWidth;
    }
    
    private void dfs(TreeNode node, int depth, int colIndex) {
        if(node == null)
            return;
        
        if(!firstColIndex.containsKey(depth))
            firstColIndex.put(depth, colIndex);
        
        int firstIndex = firstColIndex.get(depth);
        maxWidth = Math.max(maxWidth, colIndex - firstIndex + 1);
        
        dfs(node.left, depth + 1, colIndex * 2);
        dfs(node.right, depth + 1, colIndex * 2 + 1);
    }
}