//Using PriorityQueue (Time: O(NlogK) Space: O(K))
class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue();
        
        for(int n: nums) {
            this.pq.add(n);
            if(this.pq.size() > k)
               this.pq.poll();
        }
    }
    
    public int add(int val) {
        this.pq.add(val);
        if(this.pq.size() > this.k)
            this.pq.poll();
        
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
