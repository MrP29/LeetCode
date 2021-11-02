/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//Iterative DFS (Time: O(N + M) Space: O(N))
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        Map<Node, Node> visited = new HashMap();
        visited.put(node, new Node(node.val, new ArrayList()));
        
        Stack<Node> st = new Stack();
        st.push(node);
        while(!st.isEmpty()) {
            Node curNode = st.pop();
            
            for(Node neighbor: curNode.neighbors) {
                if(!visited.containsKey(neighbor)) {
                    st.push(neighbor);
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                }
                visited.get(curNode).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}

//Iterative BFS (TIme: O(N + M) Space: O(N))
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        
        Map<Node, Node> visited = new HashMap();
        
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList()));
        
        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            for(Node neighbor: cur.neighbors) {
                if(!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}

//Recursive DFS by LeetCode (Time: O(N + M) Space: O(N))
class Solution {
    Map<Node, Node> visited = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        
        if(visited.containsKey(node))
            return visited.get(node);
        
        Node cloneNode = new Node(node.val, new ArrayList());
        visited.put(node, cloneNode);
        
        for(Node neighbor: node.neighbors)
            cloneNode.neighbors.add(cloneGraph(neighbor));
        
        return cloneNode;
    }
}