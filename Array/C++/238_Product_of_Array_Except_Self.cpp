class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n, 1);
        int fromBegin = 1;
        int fromEnd = 1;

        for(int i = 0; i < n; i++) {
            res[i] *= fromBegin;
            fromBegin *= nums[i];
        }
        
        for(int i = n - 1; i >= 0; i--) {
            res[i] *= fromEnd;
            fromEnd *= nums[i];
        }
        
        return res;
    }
};