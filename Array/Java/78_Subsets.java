//Cascading (Time: O(2^N) Space: O(2^N))
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>());
        
        for(int n: nums) {
            int length = list.size();

            for(int j = 0; j < length; j++) {
                List<Integer> arr = new ArrayList(list.get(j));
                arr.add(n);
                list.add(arr);
            }
        } 
        return list;
    }
}

//Cascading by LeetCode (Time: O(2^N) Space: O(2^N))
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        list.add(new ArrayList<Integer>());

        for(int num: nums) {
            List<List<Integer>> subSet = new ArrayList();
            for(List<Integer> cur: list) {
                subSet.add(new ArrayList<Integer>(cur){{add(num);}});
            }
            for(List<Integer> newList: subSet) {
                list.add(newList);
            }
        }
        return list;
    }
}

//Recursion by LeetCode (Time: O(2^N) Space: O(N))
class Solution {
    List<List<Integer>> list = new ArrayList();
    int[] nums;
    int index;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        for(index = 0; index <= nums.length; ++index)
            backtrack(0, new ArrayList<Integer>());
        
        return list;
    }
    
    private void backtrack(int first, ArrayList<Integer> cur) {
        if(cur.size() == index) {
            list.add(new ArrayList(cur));
            return;
        }
        
        for(int i = first; i < nums.length; ++i) {
            cur.add(nums[i]);
            backtrack(i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}

//Bit Manipulation by LeetCode (Time: O(2^N) Space: O(2^N))
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        int n = nums.length;
        
        for(int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            String bitmask = Integer.toBinaryString(i).substring(1);
        
            List<Integer> cur = new ArrayList();
            for(int j = 0; j < n; ++j) {
                if(bitmask.charAt(j) == '1')
                    cur.add(nums[j]);
            }
            list.add(cur);
        }
        return list;
    }
}