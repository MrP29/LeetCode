//Array Sorting (Time: O(NlogN) Space: O(1))
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int ans = 0;
        for(int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            ans += boxTypes[i][1] * Math.min(boxTypes[i][0], truckSize);
            truckSize -= boxTypes[i][0];
        }
        
        return ans;
    }
}

//Priority Queue by LeetCode (Time: O(NlogN) Space: O(N))
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.addAll(Arrays.asList(boxTypes));
        
        int ans = 0;
        while(!pq.isEmpty()) {
            int[] box = pq.poll();
            ans += box[1] * Math.min(box[0], truckSize);
            truckSize -= box[0];
            if(truckSize <= 0)
                break;
        }
        return ans;
    }
}