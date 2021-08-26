//Using Stack with HashMap (Time: O(N) Space: O(N))
//return In-Place
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> nums = new Stack<>();
        
        for(int i = 0; i < nums2.length; i++) {
            while(!nums.isEmpty() && nums.peek() < nums2[i])
                map.put(nums.pop(), nums2[i]);

            nums.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return nums1;
    }
}

//Using Stack with HashMap (Time: O(N) Space: O(N))
//Return new Array
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> nums = new Stack<>();
        
        for(int i = 0; i < nums2.length; i++) {
            while(!nums.isEmpty() && nums.peek() < nums2[i])
                map.put(nums.pop(), nums2[i]);

            nums.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return ans;
    }
}