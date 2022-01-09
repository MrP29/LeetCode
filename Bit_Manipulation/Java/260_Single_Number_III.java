//Use Hash Set (Time: O(N) Space: O(N))
class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int n: nums) {
            if(set.contains(n))
                set.remove(n);
            else
                set.add(n);
        }
        
        int[] ans = new int[2];
        int i = 0;
        for(Object n: set.toArray()) {
            ans[i++] = (int)n;
        }
        
        return ans;
    }
}

//Use Two bitmasks by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        
        for(int n: nums) {
            bitmask ^= n;
        }
        
        int diff = bitmask & (-bitmask);
        
        int x = 0;
        for(int n: nums) {
            if((n & diff) != 0) {
                x ^= n;
            }
        }
        
        return new int[]{x, bitmask ^ x};
    }
}