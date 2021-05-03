//Two Pointers (Time: O(n) Space: O(1))
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int length = nums.length;
        while(index < length) {
            if(nums[index] == val) {
                nums[index] = nums[length - 1];
                length--;
            } else {
                index++;
            }
        }
        return index;
    }
}

//Two Pointers (Time: O(n) Space: O(1))
class Solution {
	public int removeElement(int[] nums, int val) {
		int slow = 0;
		for(int fast = 0; fast < nums.length; fast++) {
			if(nums[fast] != val) {
				nums[slow++] = nums[fast];
			}
		}
		return slow;
	}
}