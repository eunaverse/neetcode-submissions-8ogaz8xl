class Solution {
    public int countComponents(int n, int[][] edges) {

        // Map -> orgNode:nextNodes
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for(int[] edge: edges){
            edgeMap.computeIfAbsent(edge[0], ArrayList::new).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], ArrayList::new).add(edge[0]);
        
        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int group = 0;
        for(int i = 0;i < n; i++){
            if(!visited[i]){
                que.add(i);
                visited[i] = true;
                bfs(que, visited, edgeMap);
                group++;
            }
        }

        return group;
    }

    void bfs(Queue<Integer> que, boolean[] visited, Map<Integer, List<Integer>> edgeMap){
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int next: edgeMap.getOrDefault(cur, Collections.emptyList())){
                if(visited[next]) continue;
                que.add(next);
                visited[next] = true;
            }
        }

    }
}
