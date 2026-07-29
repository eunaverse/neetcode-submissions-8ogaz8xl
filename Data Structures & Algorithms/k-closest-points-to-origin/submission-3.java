class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparing(a->-a[0]));

        for(int[] p: points){
            int dist = p[0] * p[0] + p[1] * p[1];
            maxHeap.offer(new int[]{dist, p[0],p[1]});
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];

        int i = 0;
        while(!maxHeap.isEmpty()){
            res[i][0] = maxHeap.peek()[1];
            res[i++][1] = maxHeap.poll()[2];
        }


        return res;

    }
}
