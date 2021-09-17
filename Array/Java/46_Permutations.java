//Backtracking (Time: O(N!) Space: O(N!))
class Solution {
    List<List<Integer>> ans;
    Deque<Integer> list;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList();
        list = new LinkedList();
        
        for(int n: nums)
            list.add(n);
        
        backtrack(new ArrayList());
        return ans;
    }
    
    private void backtrack(ArrayList<Integer> arr) {
        if(list.isEmpty()) {
            ans.add((List<Integer>)arr.clone());
            return;
        }
        
        for(int i = 0; i < list.size(); i++) {
            arr.add(list.pollFirst());
            backtrack(arr);
            list.addLast(arr.remove(arr.size() - 1));
        }
    }
}

//Backtracking with Swap by LeetCode (Time: O(N!) Space: O(N!))
class Solution {
    List<List<Integer>> ans;
    ArrayList<Integer> list;
    int nLength;
    public List<List<Integer>> permute(int[] nums) {
        ans = new LinkedList();
        list = new ArrayList();
        
        for(int n: nums)
            list.add(n);
        
        nLength = nums.length;
        backtrack(0);
        return ans;
    }
    
    private void backtrack(int first) {
        if(first == nLength)
            ans.add(new ArrayList<Integer>(list));
        
        for(int i = first; i < nLength; i++) {
            Collections.swap(list, first, i);
            backtrack(first + 1);
            Collections.swap(list, first, i);
        }
    }
}