//Time: O(N) Space: O(1)
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        
        for(int i = 1; i < timeSeries.length; i++)
            total += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        
        return total + duration;
    }
}