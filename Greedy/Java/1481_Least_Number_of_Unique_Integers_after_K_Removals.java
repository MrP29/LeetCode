//Using Hash Map and Priority Queue (Time: O(NlogN) Space: O(N))
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: arr)
            count.put(n, count.getOrDefault(n, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();  
        for(int freq: count.values())
             pq.offer(freq);

        while(k > 0)
            k -= pq.poll();
        
        return k < 0 ? pq.size() + 1 : pq.size();
    }
}

//Using Hash Map and Array by LeetCode Discuss credited to @krrs (Time: O(N) Space: O(N))
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : arr)
            count.put(n, count.getOrDefault(n, 0) + 1);
        
        int remaining = count.size();
        int occur = 1;
        int[] occurrenceCount = new int[arr.length + 1];
        
        for (int value : count.values())
            occurrenceCount[value]++;
        
        while (k > 0) {
            if (k - occur * occurrenceCount[occur] >= 0) {
                k -= occur * occurrenceCount[occur];
                remaining -= occurrenceCount[occur++];
            }else {
                return remaining - k / occur;
            }
        }
        
        return remaining;        
    }
}