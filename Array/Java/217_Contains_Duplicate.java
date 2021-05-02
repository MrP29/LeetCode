//Hash Table(Time:O(n) Space:O(n))
class Solution {
	public boolean containsDuplicate(int[] nums) {
		set<Intager> set = new HashSet<>(nums.length);
		for(int num: nums) {
			if(set.contains(num))
				return true;
			set.add(num);
		}
		return false;
	}
}


//Sorting(Time:O(nlogn) Space:O(1))
class Solution {
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}
}