//Using Queue (Time: O(1) Space: O(1))
class RecentCounter {
    Queue<Integer> history;
    
    public RecentCounter() {
        this.history = new LinkedList();
    }
    
    public int ping(int t) {
        this.history.add(t);
        while(history.element() + 3000 < t)
            history.remove();
        
        return history.size();
    }
}

//Using Array with Binary Search and a point (Time: O(1) Space: O(N))
class RecentCounter {
    List<Integer> history;
    int oldPing;
    
    public RecentCounter() {
        history = new ArrayList<>();
        oldPing = 0;
    }
    
    public int ping(int t) {
        history.add(t);
        
        if(oldPing < history.size() && history.get(oldPing) < t - 3000)
            oldPing = search(oldPing);
        
        return history.size() - oldPing;
    }
    
    private int search(int low) {
        int high = history.size() - 1;
        int target = history.get(high) - 3000;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(history.get(mid) == target)
                return mid;
            else if(history.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */