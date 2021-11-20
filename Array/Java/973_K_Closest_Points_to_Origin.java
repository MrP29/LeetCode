//Quick Select (Time: O(N) Space: O(1))
class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int k) {
        this.points = points;
        int n = points.length;
        int min = 0;
        int max = n - 1;

        while(min <= max) {
            int pivot = quickSelect(min, max);
            if(pivot == k)
                break;
            else if(pivot < k)
                min = pivot + 1;
            else
                max = pivot - 1;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private int quickSelect(int min, int max) {
        int left = min;
        int right = max - 1;
        while(left <= right) {
            if(compare(points[left], points[max]) < 0) {
                left++;
            } else {
                swap(left, right);
                right--;
            }
        }
        swap(left, max);
        return left;
    }

    private int compare(int[] p1, int[] p2) {
        return Integer.compare(p1[0] * p1[0] + p1[1] * p1[1], p2[0] * p2[0] + p2[1] * p2[1]);
    }

    private void swap(int left, int right) {
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }
}

//Sorting (Time: O(NlogN) Space: O(logN))
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (Integer.compare(Math.abs(a[0] * a[0] + a[1] * a[1]), Math.abs(b[0] * b[0] + b[1] * b[1]))));
        
        return Arrays.copyOfRange(points, 0, k);
    }
}

//Priority Queue (Time: O(NlogK) Space: O(K))
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        for(int[] point: points) {
            pq.offer(point);
            if(pq.size() > k)
                pq.poll();
        }

        int[][] closest = new int[k][2];
        while(k > 0)
            closest[--k] = pq.poll();

        return closest;
    }
}