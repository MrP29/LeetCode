//Using Reverse(Time:O(n) Space:O(1))
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}

//Using Extra Array(Time:O(n) Space:O(n))
class Solution {
    public void rotate(int[] nums, int k) {
        //O(n) time O(n) space
        int[] newNums = new int[nums.length];
        k = k % nums.length;
        
        for(int i = 0; i < nums.length; i++) {
            newNums[i] = nums[(nums.length - k + i) % nums.length];
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}

//Using Cyclic Replacements(Time:O(n) Space:O(1))
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        int count = 0;
        for(int start = 0; count < nums.length; start++) {
            int curr = start;
            int prev = nums[start];
            do{
                int next = (curr + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                count++;
            } while(start != curr);
        }
    }
}