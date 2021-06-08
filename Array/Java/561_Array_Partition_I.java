//Time: O(n) Space: O(n)
class Solution {
    public int arrayPairSum(int[] nums) {
        int[] arr = new int[20001];
        for(int i = 0; i < nums.length; i++)
            arr[nums[i] + 10000]++;
        int sum = 0;
        boolean min = true;
        
        int count = 0;
        int index = 0;
        while(count < nums.length) {
            if(arr[index] != 0) {
                if(min) {
                    sum += index - 10000;
                    min = !min;
                } else {
                    min = !min;
                }
                arr[index]--;
                count++;
            } else {
                index++;
            }
        }
        return sum;
    }
}