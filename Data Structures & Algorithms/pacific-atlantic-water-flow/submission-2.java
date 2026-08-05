class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> que = new LinkedList<>();
        int[][] visited = new int[heights.length][heights[0].length];

        for(int c=0;c<heights[0].length;c++){
            visited[0][c] = 1;
            que.offer(new int[]{0,c});
        }
        for(int r=0;r<heights.length;r++){
            visited[r][0] = 1;
            que.offer(new int[]{r,0});
        }

        bfs(1, visited, heights, que);

        for(int c=0;c<heights[0].length;c++){
            if(visited[heights.length-1][c]==1){
                result.add(List.of(heights.length-1, c));
            }
            visited[heights.length-1][c]=2;
            que.offer(new int[]{heights.length-1, c});
        }

        for(int r=0;r<heights.length;r++){
            if(visited[r][heights[0].length-1]==1){
                result.add(List.of(r, heights[0].length-1));
            }
            visited[r][heights[0].length-1]=2;
            que.offer(new int[]{r, heights[0].length-1});
        }

        bfs(2, visited, heights, que);

        return result;
    }

    void bfs(int turn, int[][] visited, int[][] heights, Queue<int[]> que){

        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int cr = cur[0];
            int cc = cur[1];
            for(int d=0;d<4;d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if(0>nr||nr>=heights.length||0>nc||nc>=heights[0].length||visited[nr][nc]==turn||heights[nr][nc]<heights[cr][cc]) continue;

                if(turn==2 && visited[nr][nc]==1){
                    result.add(List.of(nr,nc));
                }
                
                visited[nr][nc] = turn;
                que.offer(new int[]{nr, nc});
            }


        }


    }
}
