//Binary Search (Time: O(logN) Space: O(1))
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int N = letters.length;
        int min = 0;
        int max = N;
        
        int mid;
        while(min < max) {
            mid = min + (max - min) / 2;
            
            if(letters[mid] <= target)
                min = mid + 1;
            else
                max = mid;
        }
        
        return letters[min % N];
    }
}

//Count by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] count = new boolean[26];
        for(char c: letters)
            count[c - 'a'] = true;

        while(true) {
            target++;
            if(target > 'z')
                target = 'a';
            if(count[target - 'a'])
                return target;
        }
    }
}

//Linear Search by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char c: letters) {
            if(c > target)
                return c;
        }
        return letters[0];
    }
}