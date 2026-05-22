class Solution {

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    Queue<int[]> pacQue = new LinkedList<>();
    Queue<int[]> atQue = new LinkedList<>();
    boolean[][] pacVisited = new boolean[heights.length][heights[0].length];
    boolean[][] atVisited = new boolean[heights.length][heights[0].length];
    for (int i = 0; i < heights.length; i++) {
      pacQue.add(new int[]{i, 0});
      atQue.add(new int[]{i, heights[0].length - 1});
      pacVisited[i][0] = true;
      atVisited[i][heights[0].length - 1] = true;
    }

    for (int j = 0; j < heights[0].length; j++) {
      pacQue.add(new int[]{0, j});
      atQue.add(new int[]{heights.length - 1, j});
      pacVisited[0][j] = true;
      atVisited[heights.length - 1][j] = true;
    }

    bfs(pacQue, pacVisited, heights);
    bfs(atQue, atVisited, heights);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights[0].length; j++) {
        if (pacVisited[i][j] && atVisited[i][j]) {
          ans.add(List.of(i, j));
        }
      }
    }
    return ans;
  }

  void bfs(Queue<int[]> que, boolean[][] visited, int[][] heights) {
    int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    while (!que.isEmpty()) {
      int[] cur = que.poll();

      for (int d = 0; d < 4; d++) {
        int nr = cur[0] + dir[d][0];
        int nc = cur[1] + dir[d][1];

        if (nr < 0 || nr >= visited.length || nc < 0 || nc >= visited[0].length
            || visited[nr][nc] || heights[cur[0]][cur[1]] > heights[nr][nc]) {
          continue;
        }

        que.add(new int[]{nr, nc});
        visited[nr][nc] = true;
      }
    }

  }
}
