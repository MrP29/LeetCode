/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Iterative BFS (Time: O(N) Space: O(N))
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Deque<TreeNode> dq = new LinkedList();
        dq.addLast(root);
        TreeNode cur = null;
        while(cur != null || !dq.isEmpty()) {
            cur = dq.removeFirst();
            if(cur != null) {
                dq.addLast(cur.left);
                dq.addLast(cur.right);
                sb.append(cur.val);
            } else {
                sb.append("null");
            }
            sb.append(",");
        }
        while(sb.lastIndexOf("null,") == sb.length() - 5)
            sb.delete(sb.length() - 5, sb.length());
        
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() <= 2) // []
            return null;

        String[] values = data.substring(1, data.length() - 1).split(",");
        
        int i = 0;
        TreeNode head = new TreeNode(Integer.valueOf(values[i++])); // values[i] == values[0] -> i <- 1
        Deque<TreeNode> dq = new LinkedList();
        dq.addLast(head);
        
        TreeNode cur = null;
        while(cur != null || !dq.isEmpty()) {
            cur = dq.removeFirst();
            if(cur != null) {
                if(i < values.length && !values[i].equals("null")) {
                    cur.left = new TreeNode(Integer.valueOf(values[i++]));
                    dq.addLast(cur.left);
                } else {
                    i++;
                    dq.addLast(null);
                }
                
                if(i < values.length && !values[i].equals("null")) {
                    cur.right = new TreeNode(Integer.valueOf(values[i++]));
                    dq.addLast(cur.right);
                } else {
                    i++;
                    dq.addLast(null);
                }
            }
        }
        return head;
    }
}

// Recursive DFS (Time: O(N) Space: O(N))
public class Codec {
    public String serialize(TreeNode root) {
        return serial(root, "");
    }
    
    private String serial(TreeNode root, String str) {
        if(root == null) {
            return str + "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = serial(root.left, str);
            str = serial(root.right, str);
        }
        return str;
    }
    
    public TreeNode deserialize(String data) {
        String[] strVals = data.split(",");
        List<String> values = new LinkedList<>(Arrays.asList(strVals));
        
        return deserial(values);
    }
    
    private TreeNode deserial(List<String> v) {
        if(v.get(0).equals("null")) {
            v.remove(0);
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(v.remove(0)));
        node.left = deserial(v);
        node.right = deserial(v);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));