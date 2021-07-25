//Binary Counting (Time: O(NlogN) Space: O(N))
class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        count[0] = 0;
        for(int i = 1; i <= n; i++) {
            int num = i;
            while(num > 0) {
                count[i] += num % 2 != 0 ? 1 : 0;
                num /= 2;
            }
        }
        return count;
    }
}

//Bit Manipulation (Time :O(Nk) Space:O(N)) Where k is the number of bits in num
public class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            res[i] = popcount(i);
        return res;
    }
    private int popcount(int num) {
        int count;
        for (count = 0; num != 0; ++count)
          num &= num - 1;
        return count;
    }
}

//Dynammic Programming with Most Significant Bit Manipulation (Time: O(N) Space: O(N))
class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        int pow = 1;
        
        for(int i = 1; i <= n; i++) {
            if(i == pow * 2)
                pow *= 2;
            count[i] = count[i - pow] + 1;
        }
        return count;
    }
}


//Dynammic Programming with Most Significant Bit Manipulation by LeetCode (Time: O(N) Space: O(N))
public class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        int i = 0, pow = 1;

        while (pow <= n) {
            while(i < pow && i + pow <= n){
                count[i + pow] = count[i] + 1;
                ++i;
            }
            i = 0;
            pow <<= 1;
        }
        return count;
    }
}

//Dynammic Programming with Least Significant Bit Manipulation by LeetCode(Time: O(N) Space: O(N))
public class Solution {
  public int[] countBits(int n) {
      int[] count = new int[n + 1];
      for (int i = 1; i <= n; ++i)
        count[i] = count[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
      return count;
  }
}

//Dynammic Programming with Last Set Bit Manipulation by LeetCode(Time: O(N) Space: O(N))
public class Solution {
  public int[] countBits(int n) {
      int[] count = new int[n + 1];
      for (int i = 1; i <= n; ++i)
        count[i] = count[i & (i - 1)] + 1;
      return count;
  }
}

