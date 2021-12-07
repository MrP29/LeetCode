class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int newStart = newInterval[0], newEnd = newInterval[1];
    int idx = 0, n = intervals.length;
    LinkedList<int[]> output = new LinkedList<int[]>();

    while (idx < n && newStart > intervals[idx][0])
      output.add(intervals[idx++]);

    int[] interval = new int[2];
    if (output.isEmpty() || output.getLast()[1] < newStart)
      output.add(newInterval);
    else {
        output.getLast()[1] = Math.max(output.getLast()[1], newEnd);
    }

    while (idx < n) {
      interval = intervals[idx++];
      int start = interval[0], end = interval[1];
      if (output.getLast()[1] < start)
          output.add(interval);
      else {
          output.getLast()[1] = Math.max(output.getLast()[1], end);
      }
    }
    return output.toArray(new int[output.size()][2]);
  }
}