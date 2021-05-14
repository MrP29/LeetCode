//Time: O(n) Space: O(1)
class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        while(i < arr.length - 1 && arr[i] < arr[i + 1])
            i++;
        if(i == 0 || i == arr.length - 1)
            return false;
        while(i < arr.length - 1 && arr[i] > arr[i + 1])
            i++;
        return i == arr.length - 1 ? true : false;
    }
}

//Time: O(n) Space: O(1)
class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while(i < n - 1 && arr[i] < arr[i + 1])
            i++;
        while(j > 0 && arr[j - 1] > arr[j])
            j--;
        return i > 0 && i == j && j < n - 1;
    }
}