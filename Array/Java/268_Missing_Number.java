//Sorting (Time: O(NlogN) Space: O(1))
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != nums[i])
                return i;
        }
        return nums.length;
    }
}

//Array (Time: O(N) Space: O(N))
class Solution {
    public int missingNumber(int[] nums) {
        int[] count = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 0)
                return i;
        }
        return -1;
    }
}

//Hash Set (Time: O(N) Space: O(N))
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums)
            set.add(n);

        for(int i = 0; i <= nums.length; i++) {
            if(!set.contains(i))
                return i;
        }
        return -1;
    }
}

//Bit Manipulation (Time: O(N) Space: O(1))
class Solution {
    public int missingNumber(int[] nums) {
        int num = nums.length;
        for(int i = 0; i < nums.length; i++) {
            num ^= i;
            num ^= nums[i];
        }
        return num;
    }
}

//Gauss' Formula(Sum of numbers) (Time: O(N) Space: O(1))
class Solution {
    public int missingNumber(int[] nums) {
        int sumToN = (nums.length * (nums.length + 1)) / 2;
        int sumOfNum = 0;

        for(int n: nums)
            sumOfNum += n;

        return sumToN - sumOfNum;
    }
}