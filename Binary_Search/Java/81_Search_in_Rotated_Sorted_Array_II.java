//Binary Search (Time: O(N) Space: O(1))
class Solution {
    int[] nums;
    int target;
    
    public boolean search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        int pivot = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                pivot = i;
                break;
            }
        }
        
        int index = -1;
        if(pivot == 0)
            index = searchHelper(0, nums.length - 1);
        else if(nums[0] <= target)
            index =searchHelper(0, pivot - 1);
        else
            index = searchHelper(pivot, nums.length - 1);
        
        return index != -1;
    }
    
    private int searchHelper(int min, int max) {
        int mid;
        while(min <= max) {
            mid = min + (max - min) / 2;
            if(this.nums[mid] == this.target)
                return mid;
            else if(this.nums[mid] < this.target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return -1;
    }
}

//Binary Search by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)
            return false;
        
        int min = 0;
        int max = n - 1;
        
        int mid;
        while(min <= max) {
            mid = min + (max - min) / 2;
            
            if(nums[mid] == target)
                return true;
            
            if(nums[min] == nums[mid]) {
                min++;
                continue;
            }
            
            boolean pivotA = nums[min] <= nums[mid];
            boolean targetA = nums[min] <= target;
            
            if(pivotA ^ targetA) {
                if(pivotA)
                    min = mid + 1;
                else
                    max = mid - 1;
            } else {
                if(nums[mid] < target)
                    min = mid + 1;
                else
                    max = mid - 1;
            }
        }
        return false;
    }
}