//Using Hash Map (Time: O(NlogN) Space: O(N))
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;
        
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap();
        
        for(int n: hand)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        int group = 0;
        int i = 0;
        while(i <= hand.length - groupSize) {
            boolean grouped = true;
            for(int j = 0; grouped && j < groupSize; j++) {
                if(!map.containsKey(hand[i] + j))
                    grouped = false;
            }
         
            if(grouped) {
                for(int j = 0; j < groupSize; j++) {
                    map.put(hand[i] + j, map.get(hand[i] + j) - 1);
                    if(map.get(hand[i] + j) == 0)
                        map.remove(hand[i] + j);
                }
                group++;
            } else {
                i++;
            }
        }
        return map.isEmpty();
    }
}

//Using Tree Map (Time: O(NlogN) Space: O(N))
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;
        
        TreeMap<Integer, Integer> map = new TreeMap();

        for(int n: hand)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for(int i = 0; i < hand.length / groupSize; i++) {
            int first = map.firstKey();
            if(map.get(first) == 1)
                map.remove(first);
            else
                map.put(first, map.get(first) - 1);

            for(int j = 1; j < groupSize; j++) {
                if(map.containsKey(first + j)) {
                    if(map.get(first + j) == 1)
                        map.remove(first + j);
                    else
                        map.put(first + j, map.get(first + j) - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}