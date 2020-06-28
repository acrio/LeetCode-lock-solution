/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }    
        return true;
    }
}
