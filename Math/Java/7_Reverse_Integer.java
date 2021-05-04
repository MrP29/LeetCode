//Time: O(log(x)) Space: O(1)
class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while(x != 0) {
            int lastDigit = x % 10;
            if(reversed * 10 / 10 != reversed)
                return 0;
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }
        return reversed;
    }
}