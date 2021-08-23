//Using Array (Time: O(N) Space: O(N))
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];

        for(int i = 0; i < nums.length; ++i)
            count[nums[i]]++;

        int duplicate = -1;
        int missing = -1;
        for(int i = 1; i < count.length; ++i) {
            if(count[i] == 0)
                missing = i;
            else if(count[i] > 1)
                duplicate = i;
        }
        return new int[]{duplicate, missing};
    }
}

//Using HashMap (Time: O(N) Space: O(N))
class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        
        for(int n: nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        int missing = -1;
        int duplicate = -1;
        for(int i = 1; i <= nums.length; ++i) {
            if(map.containsKey(i)) {
                if(map.get(i) == 2)
                    duplicate = i;
            } else {
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }
}

//Using HashSet (Time: O(N) Space: O(N))
class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> count = new HashSet();
        
        int duplicate = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(count.contains(nums[i]))
                duplicate = nums[i];
            count.add(nums[i]);
        }
        
        for(int i = 1; i <= nums.length; ++i) {
            if(!count.contains(i))
                return new int[]{duplicate, i};
        }
        
        return new int[]{-1, -1};
    }
}

//Sorting (Time: O(NlogN) Space: O(
class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int missing = 1;
        int duplicate = -1;
        
        for(int i = 0; i < nums.length - 1; ++i) {
            if(nums[i] == nums[i + 1]) {
                duplicate = nums[i];
            } else if(nums[i] + 1 < nums[i + 1])
                missing = nums[i] + 1;
        }
        if(nums[nums.length - 1] != nums.length)
            missing = nums.length;
        
        return new int[]{duplicate, missing};
    }
}

//In-place by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = 1;
        
        for(int n: nums) {
            if(nums[Math.abs(n) - 1] < 0)
                duplicate = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{duplicate, missing};
    }
}

//Using XOR by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0;
        int xor0 = 0;
        int xor1 = 0;
        
        for(int n: nums)
            xor ^= n;
        
        for(int i = 1; i <= nums.length; ++i)
            xor ^= i;
        
        int RMB = xor & ~(xor - 1);
        for(int n: nums) {
            if((n & RMB) != 0)
                xor1 ^= n;
            else
                xor0 ^= n;
        }
        
        for(int i = 1; i <= nums.length; ++i) {
            if((i & RMB) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }
        
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == xor0)
                return new int[]{xor0, xor1};
        }
        return new int[]{xor1, xor0};
    }
}