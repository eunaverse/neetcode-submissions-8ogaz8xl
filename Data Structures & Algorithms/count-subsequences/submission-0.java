class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        // t가 빈 문자열이면 s에서 아무것도 안 고르는 1가지
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // s[i-1]을 안 쓰는 경우
                dp[i][j] = dp[i - 1][j];

                // s[i-1]을 쓰는 경우
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }
}