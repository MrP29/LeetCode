// Sorting (Time: O(NlogN) Space: O(1))
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] < min)
                min = arr[i + 1] - arr[i];
        }
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] == min) {
                int n1 = arr[i];
                int n2 = arr[i + 1];
                list.add(new ArrayList(){{add(n1); add(n2);}});
            }
        }
        return list;
    }
}