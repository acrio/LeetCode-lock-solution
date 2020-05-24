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
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (Interval i : intervals) {
            if (!heap.isEmpty() && i.start >= heap.peek()) {
                heap.poll();
            }
            heap.offer(i.end);
        }
        return heap.size();
    }
}
