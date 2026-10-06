class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for(int[] edge: flights){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            adj.computeIfAbsent(from, HashMap::new).put(to, cost);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{src, 0, 0});

        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int cur = top[0];
            int cost = top[1];
            int stops = top[2];

            // if(dist[cur] < cost) continue;
            if(cur == dst) return cost;
            if(stops > k) continue;
            
            for(Map.Entry<Integer, Integer> entry: adj.getOrDefault(cur, Collections.emptyMap()).entrySet()){
                int to = entry.getKey();
                int nextCost = entry.getValue() + cost;

                if(dist[to][stops+1]> nextCost){
                    dist[to][stops+1] = nextCost;
                    pq.offer(new int[]{to,nextCost, stops+1});
                }
            }
        }

        return -1;
    }
}
