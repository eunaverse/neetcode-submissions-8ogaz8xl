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
    public int minMeetingRooms(List<Interval> intervals) {
       if (intervals == null || intervals.isEmpty()) return 0;

       Collections.sort(intervals, (a, b) -> a.start - b.start);
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();

       for(int i=0;i<intervals.size();i++){
        if(!minHeap.isEmpty()&&minHeap.peek() <= intervals.get(i).start){
            minHeap.poll(); // 가장 빨리 끝난 회의실 재사용
        }
        
        minHeap.offer(intervals.get(i).end); // 현재 회의 배정
       }
        return minHeap.size();

    }
}
