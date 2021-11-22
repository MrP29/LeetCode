//Using Stack (Time: O(N) Space: O(N))
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<int[]> st = new Stack();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i = 0; i < n * 2; i++) {
            while(!st.isEmpty() && st.peek()[0] < nums[i % n])
                ans[st.pop()[1]] = nums[i % n]; 

            st.push(new int[]{nums[i % n], i % n});
        }
        
        return ans;
    }
}

//Using Stack by LeetCode (Time: O(N) Space: O(N))
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack();
        for(int i = 2 * n - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i % n])
                st.pop();
            ans[i % n] = st.isEmpty() ? -1 : nums[st.peek()];
            st.push(i % n);
        }
        return ans;
    }
}

//Optimized Brute Force by LeetCode (Time: O(N^2) Space: O(n))
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }
}