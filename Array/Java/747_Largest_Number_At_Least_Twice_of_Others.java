//One Iteration (Time: O(n) Space: O(1))
class Solution {
    public int dominantIndex(int[] nums) {
        int largest = nums[0];
        int index = 0;
        int second = -1;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > largest) {
                second = largest;
                largest = nums[i];
                index = i;
            } else if(nums[i] > second) {
                second = nums[i];
            }
        }
        return largest >= second * 2 ? index : -1;
    }
}

//One Iteration (Time: O(n) Space: O(1))
class Solution {
    public int dominantIndex(int[] nums) {
        int large = nums[0];
        int index = 0;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > large) {
                if(nums[i] < large * 2)
                    index = -1;
                else
                    index = i;
                large = nums[i];
            } else {
                if(large < nums[i] * 2)
                    index = -1;
            }
        }
        return index;
    }
}

//Two Iterations (Time: O(n) Space: O(1))
class Solution {
    public int dominantIndex(int[] nums) {
        int largest = nums[0];
        int index = 0;
        for(int i = 1; i < nums.length; i++) {
            if(largest < nums[i]) {
                largest = nums[i];
                index = i;
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(i != index && nums[i] * 2 > largest)
                return -1;
        }
        return index;
    }
}