class Solution {
public:
    int search(vector<int>& nums, int target) {
        int start = 0;
        int end = nums.size() - 1;
        
        while(start <= end) {
            int midIdx = start + (end - start) / 2;
            int mid = nums[midIdx];
            if(mid == target)
                return midIdx;
            else if(mid < target) {
                start = midIdx + 1;
            } else {
                end = midIdx - 1;
            }
        }
        
        return -1;
    }
};