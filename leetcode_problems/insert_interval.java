class Solution{
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    // add intervals before newInterval
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i++]);
    }
    // merge overlapping intervals with newInterval
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
    }
    result.add(newInterval); // add merged interval
    // add remaining intervals after newInterval
    while (i < intervals.length) {
        result.add(intervals[i++]);
    }
    return result.toArray(new int[result.size()][]);
}
}