//Using an array for return (Time: O(N) Space: O(1))
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        ans[0] = 1;
        for(int i = 1; i < n; i++)
            ans[i] = ans[i - 1] * nums[i - 1];
        
        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right *= nums[i];
        }
        
        return ans;
    }
}

//Using Two Aux Arrays (Time: O(N) Space: O(N))
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        for(int i = 1; i < n; i++)
            left[i] = nums[i - 1] * left[i - 1];

        right[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--)
            right[i] = nums[i + 1] * right[i + 1];            

        int[] ans = new int[n];
        for(int i = 0; i < n; i++)
            ans[i] = left[i] * right[i];   
        
        return ans;
    }
}