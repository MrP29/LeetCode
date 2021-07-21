//Iteration (Time: O(logN) Space: O(1))
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            int mod = columnNumber % 26;
            columnNumber = (columnNumber - 1) / 26;

            if(mod != 0)
               sb.append((char)(mod + 64));
            else
               sb.append("Z");
        }
        return sb.reverse().toString();
    }
}

//Recursion by LeetCode Discuss (Time: O(logN) Space: O(logN))
class Solution {
    public String convertToTitle(int columnNumber) {
        return columnNumber == 0 ? "" : convertToTitle(--columnNumber / 26) + (char)('A' + (columnNumber % 26));
    }
}
