class Solution {
    public int lastStoneWeight(int[] stones) {
        // logN 

        // [6,4,3,2,2]
        // 2 most heaviest stones -> [3,2,2,2]
        // [2,2,1]

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stone: stones){
            pq.offer(-stone);
        }

        while(!pq.isEmpty()){
            int top1 = -pq.poll();
            if(pq.isEmpty()){
                return top1;
            }
            int top2 = -pq.poll();
            if(top1 != top2) {
                pq.offer(-top1+top2);
            }
        }

        return 0;
    }
}
