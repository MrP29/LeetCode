//Two Pointers (Time: O(n) Space: O(n))
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] squared = new int[nums.length];
        
        for(int k = nums.length - 1; k >= 0; k--) {
            int iSquared = nums[i] * nums[i];
            int jSquared = nums[j] * nums[j];
            if(iSquared > jSquared) {
                squared[k] = iSquared;
                i++;
            } else {
                squared[k] = jSquared;
                j--;
            }
        }
        return squared;
    }
}