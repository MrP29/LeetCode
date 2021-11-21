//Using Two Sum (Time: O(N^2) Space: O(logN)))
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        
        for(int k = 0; k < nums.length - 2 && nums[k] <= 0; k++) {
            if(k == 0 || nums[k - 1] != nums[k])
                twoSum(nums, k, ans);
        }
        return ans;
    }
    
    private void twoSum(int[] nums, int k, List<List<Integer>> ans) {
        int i = k + 1;
        int j = nums.length - 1;
        
        while(i < j) {
            int sum = nums[k] + nums[i] + nums[j];
            if(sum < 0) {
                i++;
            } else if(sum == 0) {
                ans.add(Arrays.asList(nums[k], nums[i++], nums[j--]));

                while(i < j && nums[i - 1] == nums[i])
                    i++;
            } else {
                j--;
            }
        }
        return;
    }
}

//No Sorting with Hash Set and Hash Map by LeetCode (Time: O(N^2) Space: O(N))
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet();
        Set<Integer> duplicate = new HashSet();
        Map<Integer, Integer> seen = new HashMap();
        
        for(int i = 0; i < nums.length; i++) {
            if(duplicate.add(nums[i])) {
                for(int j = i + 1; j < nums.length; j++) {
                    int complement = -nums[i] - nums[j];
                    if(seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        ans.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList(ans);
    }
}

//Using Two Sum with Hash Map by LeetCode (Time: O(N^2) Space: O(N))
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if(i == 0 || nums[i - 1] != nums[i])
                twoSum(nums, i, ans);
        }
        return ans;
    }
    
    private void twoSum(int[] nums, int i, List<List<Integer>> ans) {
        Set<Integer> seen = new HashSet();
        for(int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if(seen.contains(complement)) {
                ans.add(Arrays.asList(nums[i], nums[j], complement));
                while(j < nums.length - 1 && nums[j] == nums[j + 1])
                    j++;
            }
            seen.add(nums[j]);
        }
        return;
    }
}