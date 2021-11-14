//Using Hash Table (Time: O(N) Space: O(N))
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majority = new ArrayList();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int key: map.keySet()) {
            if(map.get(key) > n / 3)
                majority.add(key);
        }
        return majority;
    }
}

//Boyer-Moore Voting Algorithm by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        Integer candidate1 = null;
        int count2 = 0;
        Integer candidate2 = null;
        
        for(int num: nums) {
            if(candidate1 != null && candidate1 == num) {
                count1++;
            } else if(candidate2 != null && candidate2 == num) {
                count2++;
            } else if(count1 == 0) {
                candidate1 = num;
                count1++;
            } else if(count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        List majority = new ArrayList();
        count1 = 0;
        count2 = 0;
        
        for(int num: nums) {
            if(candidate1 != null && candidate1 == num)
                count1++;
            if(candidate2 != null && candidate2 == num)
                count2++;
        }
        
        if(count1 > nums.length / 3)
            majority.add(candidate1);
        if(count2 > nums.length / 3)
            majority.add(candidate2);
        
        return majority;
    }
}