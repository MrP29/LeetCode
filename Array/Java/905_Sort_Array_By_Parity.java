//Time: O(n) Space: O(1)
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        
        while(i < j) {
            while(i < A.length && A[i] % 2 == 0)
                i++;
            
            while(j >= 0 && A[j] % 2 != 0)
                j--;
            
            if(i < j) {
                int temp = A[i];
                A[i++] = A[j];
                A[j--] = temp;
            }
        }
        return A;
    }
}

//Sorting (Time: O(nlogn) Space: O(n))
class Solution {
    public int[] sortArrayByParity(int[] A) {
        Integer[] B = new Integer[A.length];
        for(int i = 0; i < A.length; i++)
            B[i] = A[i];

        Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));

        for(int i = 0; i < A.length; i++)
            A[i] = B[i];
        return A;
    }
}