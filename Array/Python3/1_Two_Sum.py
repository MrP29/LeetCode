# Nested loop solution (Brute Force)
# O(n^2) Time Complexity
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)    # The array size
        # The outer loop loops through 0 to (n - 1) indices and
        # the inner loop loops through (i + 1) to n indices respectively
        for i in range(n - 1):
            for j in range(i + 1, n):
                if(nums[i] + nums[j] == target):
                    return [i, j]

# Hashmap solution (One-pass Hash Table)
# O(n) Time Complexity
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)   # The array size
        numMap = {}     # Hash table

        # Loop through the array and
        # check the complement of target exists
        for i in range(n):
            complement = target - nums[i]    # Compute the complement of nums[i]
          
            # Check the complement exists in the hash table
            # If it does, return the indices
            if(complement in numMap):
                return [numMap[complement], i]

            # Add the ith element in the hash table
            numMap[nums[i]] = i
