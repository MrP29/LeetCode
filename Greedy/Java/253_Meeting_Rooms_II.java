//Using Arrays (Time: O(NlogN) Space: O(N))
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        
        int available = 0;
        int maxRoom = 0;
        
        int e = 0;
        for(int s = 0; s < n; s++) {
            if(end[e] <= start[s]) {
                e++;
                available++;
            }
            
            if(available > 0) {
                available--;
            } else {
                maxRoom++;
            }
        }
        
        return maxRoom;
    }
}

//Using Priority Queue (Time: O(NlogN) Space: O(N))
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> ongoing = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        int available = 0;
        int maxRoom = 0;
        
        for(int[] interval: intervals) {
            if(!ongoing.isEmpty() && ongoing.peek() <= interval[0]) {
                available++;
                ongoing.poll();
            }
            
            if(available > 0)
                available--;                
            else
                maxRoom++;
            
            ongoing.add(interval[1]);
        }
        return maxRoom;
    }
}

//Using Arrays by LeetCode (Time: O(NlogN) Space: O(N))
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Integer[] start = new Integer[n];
        Integer[] end = new Integer[n];
        
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start, new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }
        });
        Arrays.sort(end, new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }
        });
        
        int usedRoom = 0;
        
        int e = 0;
        for(int s = 0; s < n; s++) {
            if(end[e] <= start[s]) {
                e++;
                usedRoom--;
            }
            usedRoom++;
        }
        
        return usedRoom;
    }
}

//Using Priority Queue by LeetCode (Time: O(NlogN) Space: O(N))
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> ongoing = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        
        for(int[] interval: intervals) {
            if(!ongoing.isEmpty() && ongoing.peek() <= interval[0])
                ongoing.poll();
            ongoing.add(interval[1]);
        }

        return ongoing.size();
    }
}
