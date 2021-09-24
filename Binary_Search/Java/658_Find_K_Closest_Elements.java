//Binary Search (Time: O(logN + k) Space: O(1))
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {      
        List<Integer> list = new ArrayList();
        
        int mid = search(arr, 0, arr.length - 1, x);
        
        int left = mid;
        int right = mid;
        
        System.out.println(arr[mid]);
        for(int i = 1; i < k; i++) {
            if(left == 0)
                right++;
            else if(right == arr.length - 1)
                left--;
            else {
                if(x - arr[left - 1] <= arr[right + 1] - x)
                    left--;
                else
                    right++;
            }
        }
        
        for(int i = 0; i < k; i++)
            list.add(arr[left++]);
        
        return list;
    }
    
    private int search(int[] arr, int min, int max, int target) {
        int mid;
        while(min + 1 < max) {
            mid = min + (max - min) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                min = mid;
            else
                max = mid;
        }
        return min == arr.length - 1 || target - arr[min] <= arr[min + 1] - target ? min : min + 1;
    }
}

//Binary Search with Sliding Window by LeetCode (Time: O(logN + K) Space: O(1))
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (arr.length == k) {
            for (int i = 0; i < k; i++)
                list.add(arr[i]);
                
            return list;
        }
        
        int min = 0;
        int max = arr.length;
        int mid;
        while (min < max) {
            mid = min + (max - min) / 2;
            if (arr[mid] >= x) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        min -= 1;
        max = min + 1;
        
        while (max - min - 1 < k) {
            if (min == -1) {
                max += 1;
                continue;
            }
            
            if (max == arr.length || Math.abs(arr[min] - x) <= Math.abs(arr[max] - x))
                min -= 1;
            else
                max += 1;
        } 

        for (int i = min + 1; i < max; i++)
            list.add(arr[i]);
        
        return list;
    }
}

//Binary Search with Finding Bound by LeetCode (Time: O(logN + K) Space: O(1))
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int min = 0;
        int max = arr.length - k;
        
        int mid;
        while(min < max) {
            mid = min + (max - min) / 2;
            if(x - arr[mid] <= arr[mid + k] - x)
                max = mid;
            else
                min = mid + 1;
        }
        
        List<Integer> list = new ArrayList();
        for(int i = min; i < min + k; i++)
            list.add(arr[i]);
        
        return list;
    }
}

//Custom Sorting by LeetCode (Time: O(NlogN) Space: O(N))
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList();
        for(int n: arr)
            list.add(n);
        
        Collections.sort(list, (n1, n2) -> Math.abs(n1 - x) - Math.abs(n2 - x));
        
        list = list.subList(0, k);
        Collections.sort(list);
        
        return list;
    }
}