//Counting Factors of 5 by LeetCode (Time: O(logN) Space: O(1))
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}

//Counting Factors of 5 by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for(int i = 5; i <= n; i += 5) {
            int powOf5 = 5;
            while(i % powOf5 == 0) {
                count++;
                powOf5 *= 5;
            }
        }
        return count;
    }
}