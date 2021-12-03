//Using Hash Set (Time: O(N) Space: O(N))
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums)
            set.add(num);
        
        int longest = 0;
        for(int num: nums) {
            if(!set.contains(num - 1)) {
                int curNum = num;
                int curLongest = 1;
                
                while(set.contains(curNum + 1)) {
                    curNum++;
                    curLongest++;
                }
                
                longest = Math.max(longest, curLongest);
            }
        }
        
        return longest;
    }
}

//Using Node with Hash Map (Time: O(N) Space: O(N))
class Solution {
    class Node {
        int size;
        Node head;
        
        public Node() {
            this.size = 1;
            this.head = null;
        }
    }
    
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        Map<Integer, Node> map = new HashMap();
        int size = 1;
        
        for(int n: nums) {
            if(!map.containsKey(n)) {
                Node node = new Node();
                
                Node next = map.get(n + 1);
                if(next != null) {
                    next.head = node;
                    node.size = next.size + 1;
                    size = Math.max(size, node.size);
                }
                
                Node prev = map.get(n - 1);
                if(prev != null) {
                    while(prev.head != null)
                        prev = prev.head;
                    
                    node.head = prev;
                    prev.size = prev.size + node.size;
                    size = Math.max(size, prev.size);
                }
                map.put(n, node);
            }
        }
        return size;
    } 
}

//Sorting (Time: O(NlogN) Space: O(logN))
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        int n = nums.length;
        
        int max = 0;
        int count = 1;
        for(int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];

            if(diff == 1) {
                count++;
            } else if(diff > 1) {
                max = Math.max(max, count);
                count = 1;
            }
                
        }
        return Math.max(max, count);
    }
}

//Sorting by LeetCode (Time: O(NlogN) Space: O(logN))
class Solution {
	public int longestConsecutive(int[] nums) {
		if(nums.length == 0)
			return 0;

		Arrays.sort(nums);

		int longest = 1;
		int curLongest = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[i - 1]) {
				if(nums[i] == nums[i - 1] + 1)
					curLongest++;
				else {
					longest = Math.max(longest, curLongest);
					curLongest = 1;
				}
			}
		}
		return Math.max(longest, curLongest);
	}
}

//Brute Force by LeetCode (Time: O(N^3) Space: O(1))
class Solution {
	public int longestConsecutive(int[] nums) {
		int longest = 0;

		for(int n: nums) {
			int curNum = n;
			int curLongest = 1;

			while(searchNum(nums, curNum + 1)) {
				curNum++;
				curLongest++;
			}

			longest = Math.max(longest, curLongest);
		}

		return longest;
	}

	private boolean searchNum(int[] nums, int target) {
		for(int n: nums) {
			if(n == target)
				return true;
		}

		return false;
	}
}