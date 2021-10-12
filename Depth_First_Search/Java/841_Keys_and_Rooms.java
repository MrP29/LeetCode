//DFS (Time: O(N) Space: O(N))
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Stack<Integer> keys = new Stack();
        keys.push(0);
        
        while(!keys.isEmpty()) {
            for(int key: rooms.get(keys.pop())) {
                if(!visited[key]) {
                    visited[key] = true;
                    keys.push(key);
                }
            }
        }
        
        for(boolean visit: visited) {
            if(!visit)
                return false;
        }
        
        return true;
    }
}