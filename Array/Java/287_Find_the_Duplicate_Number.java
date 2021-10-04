//Floyd's Tortoise and Hare (Time: O(N) Space: O(1))
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        int n = nums.length;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];           
        } while(slow != fast);
        
        slow = nums[0];
        
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}

//Sorting (Time: O(NlogN) Space: O(1))
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1])
                return nums[i];
        }
        return -1;
    }
}

//Couting with Array (Time: O(N) Space: O(N))
class Solution {
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if(count[nums[i]] == 2)
                return nums[i];
        }
        return -1;
    }
}

//Hash Set (Time: O(N) Space: O(N))
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }
}

//Negative Marking by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for(int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if(nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }
        
        for(int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);
        
        return duplicate;
    }
}

//Recursion with Array as Hash Map by LeetCode (Time: O(N) Space: O(N))
class Solution {
    public int findDuplicate(int[] nums) {
        return store(nums, 0);
    }
    
    private int store(int[] nums, int cur) {
        if(cur == nums[cur])
            return cur;
        
        int next = nums[cur];
        nums[cur] = cur;
        return store(nums, next);
    }
}

//Iteration with Array as Hash Map by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public int findDuplicate(int[] nums) {
        while(nums[0] != nums[nums[0]]) {
            int next = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = next;
        }
        return nums[0];
    }
}

//Binary Search (Time: O(NlogN) Space: O(1))
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int duplicate = -1;
        
        int cur;
        while(low <= high) {
            cur = low + (high - low) / 2;
            
            int count = 0;
            for(int n: nums) {
                if(n <= cur)
                    count++;
            }
            
            if(count > cur) {
                duplicate = cur;
                high = cur - 1;
            } else {
                low = cur + 1;
            }
        }
        return duplicate;
    }
}

//Bit Manipulation (Time: O(NlogN) Space: O(1))
class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        int n = nums.length - 1;
        int max_num = findMaxNum(nums);
        int max_bit = calMaxBit(max_num);
        
        for(int bit = 0; bit < max_bit; bit++) {
            int mask = (1 << bit);
            int base_count = 0;
            int nums_count = 0;
            
            for(int i = 0; i <= n; i++) {
                if((i & mask) > 0)
                    base_count++;
                
                if((nums[i] & mask) > 0)
                    nums_count++;
            }
            
            if(nums_count > base_count)
                duplicate |= mask;
        }
        
        return duplicate;
        
    }
    
    private int findMaxNum(int[] nums) {
        int max_num = 0;
        for(int n: nums)
            max_num = Math.max(max_num, n);
        
        return max_num;
    }
    
    private int calMaxBit(int num) {
        int bits = 0;
        while(num > 0) {
            num /= 2;
            bits++;
        }
        return bits;
    }
}