//Using Hash Map (Time: O(N) Space: O(N))
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int majority = nums.length / 2;
        
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int key: map.keySet()) {
            if(map.get(key) > majority)
                return key;
        }
        return -1;
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
    int[] nums;
    public int majorityElement(int[] nums) {
        this.nums = nums;
        return majorityElementRecur(0, nums.length - 1);
    }
    
    private int majorityElementRecur(int min, int max) {
        if(min == max)
            return nums[min];
        
        int mid = (max - min) / 2 + min;
        int left = majorityElementRecur(min, mid);
        int right = majorityElementRecur(mid + 1, max);
        
        if(left == right)
            return left;
        
        return count(left, right, min, max);
    }
    
    private int count(int left, int right, int min, int max) {
        int leftCount = 0;
        int rightCount = 0;
        for(int i = min; i <= max; i++) {
            if(nums[i] == left)
                leftCount++;
            else if(nums[i] == right)
                rightCount++;
        }
        return leftCount > rightCount ? left : right;
    }
}