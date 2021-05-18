//Array (Time: O(n) Space: O(n))
class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for(int h: heights)
            count[h]++;

        int count = 0;
        int index = 0;
        for(int i = 1; i <= 100; i++) {
            while(count[i] > 0) {
                if(i != heights[index++])
                    count++;
                count[i]--;
            }
        }
        return count;
    }
}

//Sort (Time: O(nlogn) Space: O(n))
class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        
        for(int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }
        
        Arrays.sort(expected);
        
        int count = 0;
        for(int i = 0; i < heights.length; i++) {
            if(expected[i] != heights[i])
                count++;
        }
        return count;
    }
}

//Insertion Sort (Time: O(n^2) Space: O(n))
class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        
        for(int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }
        
        for(int i = 1; i < heights.length; i++) {
            int val = expected[i];
            int j = i - 1;
            while(j >= 0 && expected[j] > val) {
                expected[j + 1] = expected[j];
                j--;
            }
            expected[j + 1] = val;
        }
        
        int count = 0;
        for(int i = 0; i < heights.length; i++) {
            if(expected[i] != heights[i])
                count++;
        }
        return count;
    }
}