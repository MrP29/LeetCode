/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is lower than the guess number
 *                1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

//Binary Search (Time: O(logN) Space: O(1))
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid, res;
        while(low <= high) {
            mid = low + (high - low) / 2;
            res = guess(mid);
            if(res == 0)
                return mid;
            else if(res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}

//Recursion (Time: O(logN) Space: O(logN))
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        //int low = 1;
        //int high = n;
        
        return guess(1, n);
    }
    
    private int guess(int low, int high) {
        if(low > high)
            return -1;
        
        int mid = low + (high - low) / 2;
        int res = guess(mid);
        int ans;
        if(res == 0)
            return mid;
        else if(res < 0)
            return guess(low, mid - 1);
        
        return guess(mid + 1, high);
    } 
}

//Ternary Search by LeetCode (Time: O(logN) Space: O(1))
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid1, mid2, res1, res2;
        while(low <= high) {
            mid1 = low + (high - low) / 3;
            mid2 = high - (high - low) / 3;
            res1 = guess(mid1);
            res2 = guess(mid2);
            if(res1 == 0)
                return mid1;
            else if(res2 == 0)
                return mid2;
            else if(res1 < 0)
                high = mid1 - 1;
            else if(res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }
}