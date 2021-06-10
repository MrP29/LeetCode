//Two Pointer (Time: O(n) Space: O(1))
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target)
                return new int[] {++i, ++j};
            if(sum > target)
                j--;
            else
                i++;
        }
        return new int[] {++i, ++j};
    }
}