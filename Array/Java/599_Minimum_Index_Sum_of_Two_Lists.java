//Using HashMap and ArrayList (Time: O(Max(N, M) Space: O(Max(N, M))))
//Where N = lenght of list1, M = length of list2
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap();
        
        for(int i = 0; i < list1.length; ++i)
            map.put(list1[i], i);
        
        List<String> ans = new ArrayList();
        int min = list1.length + list2.length;
        int sum;
        for(int i = 0; i < list2.length && i <= min; ++i) {
            if(map.containsKey(list2[i])) {
                sum = i + map.get(list2[i]);
                if(sum < min) {
                    ans.clear();
                    ans.add(list2[i]);
                    min = sum;
                } else if(sum == min)
                    ans.add(list2[i]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}

//Using HashMap and TreeMap (Time: O(NlogN) Space: O(Max(N, M)))
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap();
        
        for(int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }
        
        TreeMap<Integer, List<String>> output = new TreeMap();
        for(int i = 0; i < list2.length; ++i) {
            if(map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if(output.containsKey(sum)) {
                    output.get(sum).add(list2[i]);
                } else {
                    output.put(sum, new ArrayList<String>());
                    output.get(sum).add(list2[i]);
                }
            }
        }
        
        String[] ans = new String[output.get(output.firstKey()).size()];
        return output.get(output.firstKey()).toArray(ans);
    }
}

//No Use HashMap by LeetCode (Time: O((N + M)^2) Space: O(Max(N, M)))
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList();
        
        for(int sum = 0; sum < list1.length + list2.length - 1; ++sum) {
            for(int i = 0; i <= sum; ++i) {
                int j = sum - i;
                if(i < list1.length && j < list2.length && list1[i].equals(list2[j]))
                    ans.add(list1[i]);
            }
            if(ans.size() > 0)
                break;
        }
        return ans.toArray(new String[ans.size()]);
    }
}

//Brute Force Using HashMap by LeetCode (Time: O(NM) Space: O(NM))
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, List<String>> map = new HashMap();
        
        for(int i = 0; i < list1.length; ++i) {
            for(int j = 0; j < list2.length; ++j) {
                if(list1[i].equals(list2[j])) {
                    if(!map.containsKey(i + j))
                        map.put(i + j, new ArrayList<String>());
                    map.get(i + j).add(list1[i]);
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        for(int sum: map.keySet())
            minSum = Math.min(minSum, sum);
        String[] ans = new String[map.get(minSum).size()];
        return map.get(minSum).toArray(ans);
    }
}