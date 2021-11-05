//Using Sqrt function (Time: O(sqrt(c) * logc) Space: O(1))
class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i = 0; i <= Math.sqrt(c); i++) {
            double target = Math.sqrt(c - (i * i));
            if(Math.floor(target) == Math.ceil(target))
                return true;
        }
        return false;
    }
}

//Fermat Theorem by LeetCode (Time: O(sqrt(c) * logc) Space: O(1))
class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i = 2; i * i <= c; i++) {
            int count = 0;
            if(c % i == 0) {
                while(c % i == 0) {
                    count++;
                    c /= i;
                }
                if(i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}