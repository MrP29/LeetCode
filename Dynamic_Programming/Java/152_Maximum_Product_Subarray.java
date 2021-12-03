//Dynamic Programming (Time: O(N) Space: O(1))
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxProd = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int curProdMax = cur * max;
            int curProdMin = cur * min;
            max = Math.max(cur, Math.max(curProdMax, curProdMin));
            min = Math.min(cur, Math.min(curProdMax, curProdMin));
            
            maxProd = Math.max(maxProd, max);
        }
        
        return maxProd;
    }
}

//Brute Force (Time: O(N^2) Space: O(1))
class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int prod = 1;
            for(int j = i; j < n; j++) {
                prod *= nums[j];
                maxProd = Math.max(maxProd, prod);
            }
        }

        return maxProd;
    }
}