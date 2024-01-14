# Using Array
# Time complexity   : O(len(n))
# Memory complexity : O(1)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        letters = [0] * 26
        for i in range(len(s)):
            alpha_idx1 = ord(s[i]) - ord('a')
            letters[alpha_idx1] += 1
            alpha_idx2 = ord(t[i]) - ord('a')
            letters[alpha_idx2] -= 1

        for i in range(len(letters)):
            if letters[i] != 0:
                return False
                
        return True

# Sorting
# Time complexity   : O(nlogn)
# Memory complexity : Depends on sorting algorithms
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        sorted_s = sorted(s)
        sorted_t = sorted(t)

        return sorted_s == sorted_t

# HashMap
# Time complexity   : O(n)
# Memory complexity : O(n)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        # When a letter is first encountered, it is missing from the mapping,
        # so the default_factory function calls int() to supply a default count of zero.
        count = defaultdict(int)
        for ch in s:
            count[ch] += 1

        for ch in t:
            count[ch] -= 1

        for val in count.values():
            if val != 0:
                return False

        return True