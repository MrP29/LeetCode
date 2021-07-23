//Manipulate n (Time: O(1) Space: O(1))
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int one = 1;
        for(int i = 0; i < 32; i++) {
            int digit = n & one;
            if(digit == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }
}

//Manipulate Mask (Time: O(1) Space: (1))
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++) {
            if((n & mask) != 0)
                count++;
            mask <<= 1;
        }
        return count;
    }
}

//Fliping the least significant by LeetCode (Time: O(1) Space: O(1))
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}