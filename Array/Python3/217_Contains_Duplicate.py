# Brute force (Time Limit Exceeded)
# Time complexity   : O(n^2)
# Memory complexity : O(1)
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        n = len(nums)
        for i in range(n - 1):
            for j in range(i + 1, n):
                if nums[i] == nums[j]:
                    return True
        return False

# Using Sort
# Time complexity   : O(nlogn)
# Memory complexity : Depends on sorting algorithms
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        n = len(nums)
        for i in range(n - 1):
            if(nums[i] == nums[i + 1]):
                return True
        return False

# Using Hashset
# Time complexity : O(n)
# Memory complexity : O(n)
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        seen = set()
        for num in nums:
            if num in seen:
                return True
            numbers.add(num)
        return False