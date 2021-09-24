//Binary Search (Time: O(logN) Space: O(1))
class Solution {
    int[] nums;
    int target;
    
    public int[] searchRange(int[] nums, int target) {
        if(nums.length < 1)
            return new int[] {-1, -1};
        
        this.nums = nums;
        this.target = target;

        int first = search(0, nums.length - 1, 0);
        
        if(nums[first] != target)
            return new int[] {-1, -1};
        
        int last = search(first, nums.length - 1, 1);
        
        return new int[] {first, last};
    }
    
    private int search(int min, int max, int first) {
        while(min < max) {
            int mid = (min + (max - min) / 2) + first;
            
            if(nums[mid] == target) {
                if(first == 0)
                    max = mid;
                else
                    min = mid;
            } else if(nums[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return first == 0 ? min : max;
    }
}

//Binary Search (Time: O(logN) Space: O(1))
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length < 1)
            return new int[] {-1, -1};
        
        int min = 0;
        int max = nums.length - 1;
        
        int mid;
        while(min < max) {
            mid = min + (max - min) / 2;
            
            if(nums[mid] == target)
                max = mid;
            else if(nums[mid] < target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        
        if(nums[min] != target)
            return new int[] {-1, -1};
        
        int first = min;
        
        max = nums.length - 1;
        while(min < max) {
            mid = min + (max - min) / 2;

            if(nums[++mid] == target)
                min = mid;
            else if(nums[mid] < target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        
        return new int[] {first, max};
    }
}

//Binary Search by LeetCode (Time: O(logN) Space: O(1))
class Solution {
    int[] nums;
    int target;
    
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        int first = search(true);
        
        if(first == -1)
            return new int[] {-1, -1};
        
        int last = search(false);
        
        return new int[] {first, last};
    }
    
    private int search(boolean isFirst) {
        int min = 0;
        int max = this.nums.length - 1;
        
        int mid;
        while(min <= max) {
            mid = min + (max - min) / 2;
            
            if(this.nums[mid] == target) {
                if(isFirst) {
                    if(mid == min || nums[mid - 1] != this.target)
                        return mid;
                    max = mid - 1;
                } else {
                    if(mid == max || nums[mid + 1] != this.target)
                        return mid;
                    min = mid + 1;
                }
            } else if(nums[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }
}