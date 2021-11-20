/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//DFS Annotate Parent (Time: O(N) Space: O(N))
class Solution {
    List<Integer> distanceNode;
    Map<TreeNode, TreeNode> parent;
    int k;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        distanceNode = new ArrayList();
        parent = new HashMap();
        this.k = k;
        
        traverse(root, null);
        DFS(target, new HashSet<Integer>(), 0);
        
        return distanceNode;
    }
    
    private void traverse(TreeNode node, TreeNode p) {
        if(node == null)
            return;

        parent.put(node, p);
        
        traverse(node.left, node);
        traverse(node.right, node);
        
        return;
    }
    
    private void DFS(TreeNode node, HashSet<Integer> visited, int distance) {
        if(node == null || visited.contains(node.val) || distance > k)
            return;

        if(distance == k) {
            distanceNode.add(node.val);
            return;
        }
        
        visited.add(node.val);
        
        DFS(parent.get(node), visited, distance + 1);
        DFS(node.left, visited, distance + 1);
        DFS(node.right, visited, distance + 1);
        
        return;
    }
}

//DFS Annotate Parent by LeetCode (Time: O(N) Space: O(N))
class Solution {
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap();
        DFS(root, null);
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);
        
        Set<TreeNode> visited = new HashSet();
        visited.add(target);
        visited.add(null);
        
        int dist = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                if(dist == k) {
                    List<Integer> ans = new ArrayList();
                    for(TreeNode n: queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if(!visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if(!visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode p = parent.get(node);
                if(!visited.contains(p)) {
                    visited.add(p);
                    queue.offer(p);
                }
            }
        }
        
        return new ArrayList();
    }
    
    private void DFS(TreeNode node, TreeNode p) {
        if(node != null) {
            parent.put(node, p);
            DFS(node.left, node);
            DFS(node.right, node);
        }
    } 
}

//DFS Percolate Distance by LeetCode (Time: O(N) Space: O(N))
class Solution {
    List<Integer> ans;
    TreeNode target;
    int k;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new LinkedList();
        this.target = target;
        this.k = k;
        
        DFS(root);
        
        return ans;
    }
    
    private int DFS(TreeNode node) {
        if(node == null){
            return -1;
        } else if(node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = DFS(node.left);
            int R = DFS(node.right);
            
            if(L != -1) {
                if(L == k)
                    ans.add(node.val);
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if(R != -1) {
                if(R == k)
                    ans.add(node.val);
                subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }
    
    private void subtree_add(TreeNode node, int dist) {
        if(node == null)
            return;
        if(dist == k) {
            ans.add(node.val);
        } else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}