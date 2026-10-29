class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)

        dp = [[float('inf')]*n for _ in range(m)]

        def dfs(i,j):
            if i == m:
                return n - j # insert 
            if j == n:
                return m - i # delete
            
            if dp[i][j] != float('inf'):
                return dp[i][j]

            if word1[i] == word2[j]:
                dp[i][j] = dfs(i + 1, j + 1)
                return dp[i][j]
            
            dp[i][j] = min(dfs(i+1, j), dfs(i, j+1)) + 1
            dp[i][j] = min(dp[i][j], dfs(i+1, j+1)+1)

            return dp[i][j]
        return dfs(0,0)
            

            
