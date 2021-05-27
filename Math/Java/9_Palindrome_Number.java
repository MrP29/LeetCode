//Integer Comparison (Time: O(log(n)) Space: O(1))
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0))
            return false;
        
        int reversed = 0;
        while(x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
}

//String Comparison (Time: O(n) Space: O(n))
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        String s = Integer.toString(x);
        StringBuilder firstHalf = new StringBuilder();
        StringBuilder lastHalf = new StringBuilder();
        if(s.length() % 2 == 0) {
            firstHalf.append(s.substring(0, s.length() / 2));
            lastHalf.append(s.substring(s.length() / 2));
        } else {
            firstHalf.append(s.substring(0, s.length() / 2));
            lastHalf.append(s.substring(s.length() / 2 + 1));
        }
        lastHalf.reverse();
        
        return firstHalf.toString().equals(lastHalf.toString());
    }
}