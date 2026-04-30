class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] cur = intervals[0];

        for(int i=1;i<n;i++){
            if(intervals[i][0] > cur[1]){
                res.add(cur);
                cur = intervals[i];
            }
            else{
               
                cur[1] = Math.max(cur[1], intervals[i][1]);
                
            }
        }
        res.add(cur);
        
        
        return res.toArray(new int[res.size()][]);
    }
}
