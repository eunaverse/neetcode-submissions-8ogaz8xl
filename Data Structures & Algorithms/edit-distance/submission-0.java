class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(word1, word2, 0, 0, dp);
    }

    int dfs(String word1, String word2, int w1, int w2, int[][] dp){
        if (w1 == word1.length()) return word2.length() - w2; // insert 남은 만큼
        if (w2 == word2.length()) return word1.length() - w1; // delete 남은 만큼
    

        if(dp[w1][w2]!=-1) return dp[w1][w2];

        dp[w1][w2] = dfs(word1, word2, w1+1, w2+1, dp); // replace or as it is
        
        if(word1.charAt(w1) != word2.charAt(w2)){
            dp[w1][w2] = Math.min(dp[w1][w2], dfs(word1, word2, w1+1, w2, dp)); // remove
            dp[w1][w2] = Math.min(dp[w1][w2], dfs(word1,word2, w1, w2+1, dp));  // insert
            dp[w1][w2] += 1;
        }

        return dp[w1][w2];
    }
}
