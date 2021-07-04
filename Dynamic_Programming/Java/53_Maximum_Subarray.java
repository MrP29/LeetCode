//Time: O(n) Space: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int newSum = sum + nums[i];
            sum = newSum > nums[i] ? newSum : nums[i];
            max = sum > max ? sum : max;
        }
        return max;
    }
}

//Divide and Conquer Recursion by LeetCode (Time: O(nlogn) Space: O(logn))
class Solution {
    public int[] numsArray;

    public int maxSubArray(int[] nums) {
        numsArray = nums;
        return findMaxSubArray(0, numsArray.length - 1);
    }

    private int findMaxSubArray(int left, int right) {
        if(left > right) {
            return Integer.MIN_VALUE;
        }

        int mid = (left + right) / 2;
        int cur = 0;
        int leftSum = 0;
        int rightSum = 0;

        for(int i = mid - 1; i >= left; i--) {
            cur += numsArray[i];
            leftSum = Math.max(leftSum, cur);
        }

        cur = 0;
        for(int i = mid + 1; i <= right; i++) {
            cur += numsArray[i];
            rightSum = Math.max(rightSum, cur);
        }

        int sum = numsArray[mid] + leftSum + rightSum;

        int leftHalf = findMaxSubArray(left, mid - 1);
        int rightHalf = findMaxSubArray(right, mid + 1);

        return Math.max(sum, Math.max(leftHalf, rightHalf));
    }
}