//Array Count (Time: O(N + M) Space: O(1))
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] count = new boolean[1001];
        
        for(int n: nums1)
            count[n] = true;
        
        List<Integer> list = new ArrayList();
        for(int n: nums2) {
            if(count[n]) {
                list.add(n);
                count[n] = false;
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        
        return ans;
    }
}

//Hash Set (Time: O(N + M) Space: O(N + M))
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        
        for(int n: nums1)
            set1.add(n);
        for(int n: nums2)
            set2.add(n);
        
        List<Integer> list = new ArrayList();
        for(Integer key: set1) {
            if(set2.contains(key))
                list.add(key);
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        
        return ans;        
    }
}