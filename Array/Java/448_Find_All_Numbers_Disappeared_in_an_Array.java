//Array (Time: O(n) Space: O(n))
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] count = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            count[nums[i] - 1]++;
        }
        
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(count[i] == 0)
                arr.add(i + 1);
        }
        return arr;
    }
}

//In place (Time: O(n) Space: O(1))
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] *= -1;
        }

        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                arr.add(i + 1);
        }
        return arr;
    }
}

//Hash Table (Time: O(n) Space: O(n))
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i))
                list.add(i);
        }

        return list;
    }
}