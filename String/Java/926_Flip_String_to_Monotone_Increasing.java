//Counting Optimal Flips (Time: O(N) Space: O(1))
class Solution {
    public int minFlipsMonoIncr(String s) {
        int sLength = s.length();
        int start = 0;
        
        int oneToZero = 0;
        int optFlip = 0;
        while(start < sLength) {
            if(s.charAt(start) == '0')
                optFlip = Math.min(oneToZero, optFlip + 1);
            else
                oneToZero++;
            
            start++;
        }
        
        return optFlip;
    }   
}

//Using Prefix Sums by LeetCode (Time: O(N) Space: O(N))
class Solution {
    public int minFlipsMonoIncr(String s) {
        int sLength = s.length();
        int[] ones = new int[sLength + 1];
        for(int i = 0; i < sLength; i++)
            ones[i + 1] = ones[i] + (s.charAt(i) == '1' ? 1 : 0);
        
        int flips = Integer.MAX_VALUE;
        for(int i = 0; i <= sLength; i++) {
            int zeros = sLength - i - (ones[sLength] - ones[i]);
            flips = Math.min(flips, ones[i] + zeros);
        }
        
        return flips;
    }
}