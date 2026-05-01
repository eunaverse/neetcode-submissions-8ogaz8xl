/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // (0,30) (5,10) -> front.end > back.start
        Collections.sort(intervals, Comparator.comparingInt(i->i.start));

        for(int i=1;i<intervals.size();i++){
            Interval front = intervals.get(i-1);
            Interval back = intervals.get(i);

            if(front.end > back.start){
                return false;
            }
        }
        return true;
    }
}
