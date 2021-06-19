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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
            return list;

        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty()) {
            root = queue.remove();
            if(root != null) {
                arr.add(root.val);
                next.add(root.left);
                next.add(root.right);
            }

            if(queue.isEmpty()) {
                if(!arr.isEmpty())
                    list.add(arr);
                queue = next;
                arr = new ArrayList<>();
                next = new LinkedList<>();
            }

        }
        return list;
    }
}

//Iteration (Time: O(n) Space: O(n))
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for(int depth = 0; !queue.isEmpty(); depth++) {
            list.add(new ArrayList<Integer>());
            int leaves = queue.size();

            for(int i = 0; i < leaves; i++) {
                root = queue.remove();
                list.get(depth).add(root.val);
                if(root.left != null)
                    queue.add(root.left);
                if(root.right != null)
                    queue.add(root.right);
            }
        }
        return list;
    }
}

//Recursion (Time: O(n) Space: O(n))
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return list;
        breadthFirstSearch(root, 0);
        return list;
    }

    private void breadthFirstSearch(TreeNode root, int depth) {
        if(list.size() == depth)
            list.add(new ArrayList<Integer>());

        list.get(depth).add(root.val);

        if(root.left != null)
            breadthFirstSearch(root.left, depth + 1);
        if(root.right != null)
            breadthFirstSearch(root.right, depth + 1);
    }
}