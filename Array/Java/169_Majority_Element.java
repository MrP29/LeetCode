//Using Hash Map (Time: O(N) Space: O(N))
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Integer majority = null;
        for(int key: map.keySet()) {
            if(majority == null)
                majority = key;
            if(map.get(majority) < map.get(key))
                majority = key;
        }
        return majority;
    }
}

//Sorting (Time: O(NlogN) Space: O(logN))
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

//Boyer-Moor Voting Algorithm by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        
        for(int num: nums) {
            if(count == 0)
                candidate = num;
            
            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate;
    }
}

//Randomization by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public int majorityElement(int[] nums) {
        Random rand = new Random();
        int count = nums.length / 2;
        
        while(true) {
            int candidate = nums[rand.nextInt(nums.length)];
            if(countOccurences(nums, candidate) > count)
                return candidate;
        }
    }
    
    private int countOccurences(int[] nums, int candidate) {
        int count = 0;
        for(int num: nums) {
            if(num == candidate)
                count++;
        }
        return count;
    }
}

//Divide and Conquer by LeetCode (Time: O(NlogN) Space: O(logN))
class Solution {
    public int majorityElement(int[] nums) {
        return majorityElementRecur(nums, 0, nums.length - 1);
    }
    
    private int majorityElementRecur(int[] nums, int min, int max) {
        if(min == max)
            return nums[min];
        
        int mid = (max - min) / 2 + min;
        int left = majorityElementRecur(nums, min, mid);
        int right = majorityElementRecur(nums, mid + 1, max);
        
        if(left == right)
            return left;
        
        int leftCount = count(nums, left, min, max);
        int rightCount = count(nums, right, min, max);
        
        return leftCount > rightCount ? left : right;
    }
    
    private int count(int[] nums, int num, int min, int max) {
        int count = 0;
        for(int i = min; i <= max; i++) {
            if(nums[i] == num)
                count++;
        }
        return count;
    }
}