//Range Caching (Time: O(N + k) Space: O(1))
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        
        for(int[] update: updates) {
            res[update[0]] += update[2];
            if(update[1] + 1 < length)
                res[update[1] + 1] -= update[2];
        }
        
        for(int i = 1; i < length; i++) {
            res[i] = res[i] + res[i - 1];
        }
        
        return res;
    }
}

//Range Caching with Aux Array (Time: O(N + k) Space: O(N))
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        
        int n = updates.length;
        int[] increases = new int[length + 1];
        for(int[] update: updates) {
            increases[update[0]] += update[2];
            increases[update[1] + 1] -= update[2];
        }
         
        for(int i = 0; i < length; i++)
            res[i] = i == 0 ? increases[i] : increases[i] + res[i - 1];
        
        return res;
    }
}

//Sorting with Aux Array (Time: O(N + klogk) Space: O(k))
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        
        int n = updates.length;
        int[][] start = new int[n][2];
        int[][] end = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            start[i][0] = updates[i][0];
            start[i][1] = updates[i][2];
            end[i][0] = updates[i][1];
            end[i][1] = updates[i][2];
        }
        
        Arrays.sort(start, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(end, (a, b) -> Integer.compare(a[0], b[0]));
        
        int curSum = 0, s = 0, e = 0;
        for(int i = 0; i < length; i++) {
            while(s < n && start[s][0] <= i)
                curSum += start[s++][1];

            while(e < n && end[e][0] < i)
                curSum -= end[e++][1];

            res[i] = curSum;
        }
        
        return res;
    }
}

//Brute Force (Time: O(N * k) Space: O(1))
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        
        for(int[] update: updates) {
            for(int i = update[0]; i <= update[1]; i++)
                res[i] += update[2];
        }
        return res;
    }
}