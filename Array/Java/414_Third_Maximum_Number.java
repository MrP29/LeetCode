//HashSet (Time: O(n) Space:O(n))
class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums)
            set.add(n);

        if(set.size() < 3)
            return Collections.max(set);

        for(int i = 0; i < 2; i++)
            set.remove(Collections.max(set));

        return Collections.max(set);
    }
}


//TreeSet (Time: O(nlogn) Space:O(n))
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        
        if(set.size() < 3)
            return set.last();
        
        for(int i = 0; i < 2; i++)
            set.pollLast();
        
        return set.last();
    }
}