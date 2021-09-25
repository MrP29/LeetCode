//Quick Select with Hash Map (Time: O(N) Space: O(N)) - Worst Case O(N^2)
class Solution {
    int[] count;
    Map<Integer, Integer> map;
    
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k)
            return nums;
        
        map = new HashMap();
        for(int n: nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        count = new int[map.size()];
        int c = 0;
        for(int n: map.keySet())
            count[c++] = n;
        
        int min = 0;
        int max = count.length - 1;
        int pivot;
        while(min < max) {
            pivot = sort(min, max);
            
            if(pivot == count.length - k)
                break;
            else if(pivot < count.length - k)
                min = pivot + 1;
            else
                max = pivot - 1;
        }
        
        return Arrays.copyOfRange(count, count.length - k, count.length);
    }
    
    private int sort(int min, int max) {
        int pivot = this.map.get(count[max]);

        for(int j = min; j < max; j++) {
            if(map.get(count[j]) < pivot)
                swap(count, min++, j);
        }
        
        swap(count, min, max);
        return min;
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

//Sorting with Tree Map (Time: O(NlogK) Space: O(N + K))
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1)
            return new int[] {nums[0]};
        
        Arrays.sort(nums);
        
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;
            } else {
                if(map.containsKey(count))
                    map.get(count).add(nums[i - 1]);
                else {
                    int index = i - 1;
                    map.put(count, new ArrayList() {{add(nums[index]);}});
                }
                count = 1;
            }
        }
        
        if(map.containsKey(count))
            map.get(count).add(nums[nums.length - 1]);
        else
            map.put(count, new ArrayList() {{add(nums[nums.length - 1]);}});
        
        int[] ans = new int[k];
        for(int i = 0; i < k;) {
            List<Integer> list = map.remove(map.lastKey());
            for(int j = 0; j < list.size(); j++) {
                ans[i++] = list.get(j);
            }
        }

        return ans;
    }
}

//Priority Queue and Hash Map (Time: O(NlogK) Space: O(N + K))
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k)
            return nums;
        
        Map<Integer, Integer> map = new HashMap();
        for(int n: nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        Queue<Integer> pq = new PriorityQueue((n1, n2) -> map.get(n1) - map.get(n2));
        
        for(int n: map.keySet()) {
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--)
            ans[i] = pq.poll();
        
        return ans;
    }
}