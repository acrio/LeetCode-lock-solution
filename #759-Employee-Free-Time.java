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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();
        List<Interval> tasks = new ArrayList<>();
        for(List<Interval> currrentEmplyeeTask : schedule){
            tasks.addAll(currrentEmplyeeTask);
        }
        if(tasks.size() < 1)
            return ans;

        Collections.sort(tasks, (a, b)->(a.start - b.start));
        Interval prev = tasks.get(0);

        for(int i = 0; i < tasks.size(); i++){
            Interval cur = tasks.get(i);
            if(prev.end < cur.start) {
                ans.add(new Interval(prev.end, cur.start));
                prev = cur;
            } else {
                prev = prev.end < cur.end ? cur : prev;
            }
        }
        return ans;
    }
}
