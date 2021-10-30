//Right to Left (Time: O(N) Space: O(1))
class Solution {
    public int titleToNumber(String columnTitle) {
        int column = 0;
        int titleLength = columnTitle.length()

        for(int i = titleLength - 1; i >= 0; i--)
            column += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, titleLength - i - 1);

        return column;
    }
}

//Left to Right (Time: O(N) Space: O(1)))
class Solution {
    public int titleToNumber(String columnTitle) {
        int column = 0;
        for(int i = 0; i < columnTitle.length(); i++)
            column = (column * 26) + (columnTitle.charAt(i) - 'A' + 1);

        return column;
    }
}