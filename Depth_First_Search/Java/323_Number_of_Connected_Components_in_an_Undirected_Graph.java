//DFS (Time: O(V + E) Space: O(V + E))
class Solution {
    List<Integer>[] adjList;
    int[] visited;
    
    public int countComponents(int n, int[][] edges) {
        adjList = new ArrayList[n];
        visited = new int[n];
        int components = 0;
        
        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList();
        
        for(int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                dfs(i);
                components++;
            }
        }
        
        return components;
    }
    
    private void dfs(int vertex) {
        visited[vertex] = 1;
        
        for(int i = 0; i < adjList[vertex].size(); i++) {
            if(visited[adjList[vertex].get(i)] == 0) {
                dfs(adjList[vertex].get(i));
            }
        }
    }
}

//Disjoint Set Union by LeetCode (Time: O(E * alpha(N)) Space: O(V))
class Solution {
    int[] representative;
    int[] size;
    
    public int countComponents(int n, int[][] edges) {
        representative = new int[n];
        size = new int[n];
        
        for(int i = 0; i < n; i++) {
            representative[i] = i;
            size[i] = 1;
        }
        
        int components = n;
        for(int i = 0; i < edges.length; i++) {
            components -= combine(edges[i][0], edges[i][1]);
        }
        
        return components;
    }
    
    private int combine(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);
        
        if(v1 != v2) {
            if(size[v1] > size[v2]) {
                size[v1] += size[v2];
                representative[v2] = v1;
            } else {
                size[v2] += size[v1];
                representative[v1] = v2;
            }
            
            return 1;
        }
        
        return 0;
    }
    
    private int find(int v) {
        if(v == representative[v])
            return v;
        
        return representative[v] = find(representative[v]);
    }
}