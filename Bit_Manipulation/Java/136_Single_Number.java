class Solution {
	public int singleNumber(int[] nums) {
		int result = 0;
		for(int num: nums) {
			result ^= num;
		}
		return result;
	}
}

//Using Hash Table(Time:O(n) Space:O(n))
class Solution {
	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i]))
				set.remove(nums[i]);
			else
				set.add(nums[i]);
		}
		return set.iterator().next();
	}
}

//Using Math(Time:O(n) Space:O(n))
class Solution {
	public int singleNumber(int[] nums) {
		int sumOfSet = 0;
		int sumOfNums = 0;
		Set<Integer> set = new HashSet<>();

		for(int num: nums) {
			if(!set.contains(num)) {
				set.add(num);
				sumOfSet += num;
			}
			sumOfNums += num;
		}
		return 2 * sumOfSet - sumOfNums;
	}
}
