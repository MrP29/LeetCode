//Three Pointer (Time: O(n + m) Space: O(1))
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;
        while(i >= 0 && n > 0) {
            if(m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[--i] = nums1[--m];
            } else {
                nums1[--i] = nums2[--n];
            }
        }
    }
}