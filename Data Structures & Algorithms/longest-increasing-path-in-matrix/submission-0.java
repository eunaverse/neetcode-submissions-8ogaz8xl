class Solution {

  public int longestIncreasingPath(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    int result = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (dp[i][j] > 0) {
          continue;
        }
        int cnt = dfs(dp, matrix, i, j);
        result = Math.max(cnt, result);
      }
    }
    return result;
  }

  int dfs(int[][] dp, int[][] matrix, int r, int c) {
    if (dp[r][c] > 0) {
      return dp[r][c];
    }
    System.out.printf("r: %d, c: %d", r,c);

    if (r + 1 < matrix.length && matrix[r][c] < matrix[r + 1][c]) {
      dp[r][c] = Math.max(dp[r][c], dfs(dp, matrix, r + 1, c));
    }
    if (r - 1 >= 0 && matrix[r][c] < matrix[r - 1][c]) {
      dp[r][c] = Math.max(dp[r][c], dfs(dp, matrix, r - 1, c));
    }
    if (c + 1 < matrix[r].length && matrix[r][c] < matrix[r][c + 1]) {
      dp[r][c] = Math.max(dp[r][c], dfs(dp, matrix, r, c + 1));
    }
    if (c - 1 >= 0 && matrix[r][c] < matrix[r][c - 1]) {
      dp[r][c] = Math.max(dp[r][c], dfs(dp, matrix, r, c - 1));
    }
    dp[r][c] += 1; //self

    return dp[r][c];
  }
}
