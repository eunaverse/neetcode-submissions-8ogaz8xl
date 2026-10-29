class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        m, n = len(s), len(t)

        dp = {}

        def dfs(i, j):
            if j == n:
                return 1
            if i == m:
                return 0
            
            if (i,j) in dp:
                return dp[(i,j)]
           
            dp[(i,j)] = dfs(i+1,j)
            if s[i] == t[j]:
                dp[(i,j)] += dfs(i+1,j+1)
            
            return dp[(i,j)]
        
        return dfs(0,0)
            
