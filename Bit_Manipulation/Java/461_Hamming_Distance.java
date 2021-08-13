//XOR (Time: O(1) Space: O(1)
class Solution {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        while(x != 0 || y != 0) {
            int xBinary = x & 1;
            int yBinary = y & 1;

            if(xBinary != yBinary)
                distance++;
            
            x >>= 1;
            y >>= 1;
        }
        return distance;
    }
}

//XOR (Time: O(1) Space: O(1))
class Solution {
    public int hammingDistance(int x, int y) {
        int xy = x ^ y;
        int distance = 0;
        while(xy != 0) {
            if((xy & 1) == 1)
                distance++;
            xy >>= 1;
        }
        return distance;
    }
}

//XOR with Brian Kernighan's Algorithm by LeetCode (Time: O(1) Space: O(1))
class Solution {
    public int hammingDistance(int x, int y) {
        int xy = x ^ y;
        int distance = 0;
        while(xy != 0) {
            distance++;
            xy &= (xy - 1);
        }
        return distance;
    }
}

//Built in Method (Time: O(1) Space: O(1))
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}