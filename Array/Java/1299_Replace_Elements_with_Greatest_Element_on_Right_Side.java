//Time: O(n) Space: O(1)
class Solution {
    public int[] replaceElements(int[] arr) {
        int i = arr.length - 1;
        int max = -1;
        while(i >= 0) {
            int temp = arr[i];
            arr[i--] = max;
            if(temp > max)
                max = temp;
        }
        return arr;
    }
}

//Time: O(n^2) Space: O(1)
class Solution {
    public int[] replaceElements(int[] arr) {
        int i = 0;
        while(i < arr.length - 1) {
            int max = arr[i + 1];
            int maxIndex = i + 1;
            int j;
            for(j = i + 2; j < arr.length; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            while(i < maxIndex)
                arr[i++] = max;
        }
        arr[arr.length - 1] = -1;
        
        return arr;
    }
}