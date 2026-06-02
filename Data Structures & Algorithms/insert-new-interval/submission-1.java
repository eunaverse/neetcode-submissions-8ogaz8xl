 class Solution {
         public int[][] insert(int[][] intervals, int[] newInterval) {
                  List<int[]> res = new ArrayList<>();
                   
                            int idx = 0;
                                     boolean merged = false;
                                              while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
                                                           res.add(intervals[idx++]);
                                                                    }
                                                                     
                                                                              while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
                                                                                           newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
                                                                                                        newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
                                                                                                                     idx++;
                                                                                                                              }
                                                                                                                               
                                                                                                                                        res.add(newInterval);
                                                                                                                                         
                                                                                                                                                  while (idx < intervals.length) {
                                                                                                                                                               res.add(intervals[idx++]);
                                                                                                                                                                        }
                                                                                                                                                                         
                                                                                                                                                                                  return res.toArray(new int[res.size()][]);
                                                                                                                                                                                       }
                                                                                                                                                                                        }

 