//Two Pointers Iteration (Time: O(N) Space: O(1))
class Solution {
    public void reverseString(char[] s) {
        for(int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}

//Recursion (Time: O(N) Space: O(N))
class Solution {
    public void reverseString(char[] s) {
        reverseRecursion(s, 0, s.length - 1);
    }
    
    private void reverseRecursion(char[] s, int left, int right) {
        if(left >= right)
            return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        
        reverseRecursion(s, left + 1, right - 1);
    }
}