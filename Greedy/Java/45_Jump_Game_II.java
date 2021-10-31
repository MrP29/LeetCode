//Greedy Algorithm (Time: O(N) Space: O(1))
class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int cur = 0;
        int farthest = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if(i == cur) {
                count++;
                cur = farthest;
            }
        }
        return count;
    }
}