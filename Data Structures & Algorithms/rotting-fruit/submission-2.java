class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int time = 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int[] cur = queue.poll();
                int cr = cur[0];
                int cc = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i];
                    int nc = cc + dc[i];

                    if (nr < 0 || nr >= grid.length ||
                        nc < 0 || nc >= grid[0].length ||
                        grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int[]{nr, nc});
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}