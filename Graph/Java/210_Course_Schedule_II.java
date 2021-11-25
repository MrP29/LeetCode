//Recursive Topological Sorting (Time: O(V + E) Space: O(V + E))
class Solution {class Solution {
    int WHITE = 0;
    int GRAY = 1;
    int BLACK = 2;
    
    boolean isCyclic;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    Stack<Integer> topo;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        isCyclic = false;
        color = new HashMap();
        adjList = new HashMap();
        topo = new Stack();
        
        for(int i = 0; i < numCourses; i++)
            color.put(i, WHITE);
        
        for(int[] pre: prerequisites) {
            if(!adjList.containsKey(pre[1]))
                adjList.put(pre[1], new ArrayList());
            adjList.get(pre[1]).add(pre[0]);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(color.get(i) == WHITE)
                dfs(i);
        }

        if(isCyclic)
            return new int[]{};
        
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            res[i] = topo.pop();
        }
        
        return res;
    }
    
    private void dfs(int cNum) {
        if(isCyclic)
            return;
        
        color.put(cNum, GRAY);
        for(int nextCourse: adjList.getOrDefault(cNum, new ArrayList<Integer>())) {
            if(color.get(nextCourse) == WHITE) 
                dfs(nextCourse);
            else if(color.get(nextCourse) == GRAY)
                isCyclic = true;
        }
        color.put(cNum, BLACK);
        topo.push(cNum);
    }
}

//Indegree Of Graph with Hash Map (Time: O(V + E) Space: O(V + E))
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isCyclic = false;
        Map<Integer, List<Integer>> adjList = new HashMap();
        int[] indegree = new int[numCourses];
        int[] scheduled = new int[numCourses];
        
        for(int[] pre: prerequisites) {
            if(!adjList.containsKey(pre[1]))
                adjList.put(pre[1], new ArrayList());
            adjList.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }
        
        int i = 0;
        while(!queue.isEmpty()) {
            int cNum = queue.remove();
            scheduled[i++] = cNum;
            
            if(adjList.containsKey(cNum)) {
                for(int nextCourse: adjList.get(cNum)) {
                    indegree[nextCourse]--;
                    
                    if(indegree[nextCourse] == 0)
                        queue.offer(nextCourse);
                }
            }
        }
        
        if(i == numCourses)
            return scheduled;
        
        return new int[]{};
    }
}

//Indegree of Graph (Time: O(V^2) Space: O(V))
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int order = 0;

        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites) {
            inDegree[pre[0]]++;
        }
        
        while(order < numCourses) {
            int candidate = -1;
            for(int i = 0; i < numCourses; i++) {
                if(inDegree[i] == 0) {
                    candidate = i;
                    break;
                }
            }
            
            for(int[] pre: prerequisites) {
                if(pre[1] == candidate)
                    inDegree[pre[0]]--;
            }
            
            if(candidate != -1) {
                res[order++] = candidate;
                inDegree[candidate] = -1;
            }
            else
                return new int[]{};
        }
        return res;
    }
}