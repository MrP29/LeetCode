//PriorityQueue (Time: O(NlogN) Space: O(N)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        
        for(int stone: stones)
            queue.offer(stone);
        
        while(queue.size() > 1) {
            int biggest = queue.poll();
            int second = queue.poll();
            if(biggest > second)
                queue.offer(biggest - second);
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}

//In-place Array (Time: O(N^3) Space: O(1))
class Solution {
    public int lastStoneWeight(int[] stones) {
        for(int i = 0; i < stones.length - 1; i++) {
            Arrays.sort(stones);
            stones[stones.length - 1] -= stones[stones.length - 2];
            stones[stones.length - 2] = 0;
        }
        return stones[stones.length - 1];
    }
}

//ArrayList (Time: O(N^2) Space: O(N))
class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for(int stone: stones)
            stoneList.add(stone);
        
        while(stoneList.size() > 1) {
            int biggest = removeBiggest(stoneList);
            int second = removeBiggest(stoneList);
            if(biggest > second)
                stoneList.add(biggest - second);
        }   
        return stoneList.isEmpty() ? 0 : stoneList.get(0);
    }
    
    private int removeBiggest(List<Integer> stones) {
        int biggestIndex = 0;
        for(int i = 1; i < stones.size(); i++) {
            if(stones.get(i) > stones.get(biggestIndex))
                biggestIndex = i;
        }
        int biggest = stones.get(biggestIndex);
        stones.remove(biggestIndex);
        return biggest;
    }    
}

//Bucket Sort by LeetCode (Time: O(N + W) Space: O(W))
class Solution {
    public int lastStoneWeight(int[] stones) {
        int maxWeight = stones[0];
        for(int stone: stones)
            maxWeight = Math.max(maxWeight, stone);

        int[] buckets = new int[maxWeight + 1];

        for(int weight: stones)
            buckets[weight]++;

        int biggestWeight = 0;
        int currentWeight = maxWeight;
        while(currentWeight > 0) {
            if(buckets[currentWeight] == 0) {
                currentWeight--;
            } else if(biggestWeight == 0) {
                buckets[currentWeight] %= 2;
                if(buckets[currentWeight] == 1) {
                    biggestWeight = currentWeight;
                }
                currentWeight--;
            } else {
                buckets[currentWeight]--;
                if(biggestWeight - currentWeight <= currentWeight) {
                    buckets[biggestWeight - currentWeight]++;
                    biggestWeight = 0;
                } else {
                    biggestWeight -= currentWeight;
                }
            }
        }
        return biggestWeight;
    }
}