//Using Array (Time: O(N) Space: O(1))
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] duration = new int[60];
        int pairs = 0;

        for(int t: time) {
            pairs += t % 60 == 0 ? duration[0] : duration[60 - (t % 60)];
            duration[t % 60]++;
        }
        return pairs;
    }
}

//Using HashMap (Time: O(N) Space: (1))
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> duration = new HashMap();
        int pairs = 0;

        for(int t: time) {
            int pairKey = t % 60 == 0 ? 0 : 60 - (t % 60);
            if(duration.containsKey(pairKey))
                pairs += duration.get(pairKey);
            
            duration.put((t % 60), duration.getOrDefault((t % 60), 0) + 1);
        }
        return pairs;
    }
}

//Brute Force (Time: O(N^2) Space: O(1))
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int pairs = 0;
        
        for(int i = 0; i < time.length; i++) {
            for(int j = i + 1; j < time.length; j++) {
                if((time[i] + time[j]) % 60 == 0)
                    pairs++;
            }
        }
        return pairs;
    }
}