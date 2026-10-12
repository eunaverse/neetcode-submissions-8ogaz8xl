class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [None] * len(s)
        
        def dfs(i):
            if i >= len(s):
                return True
            if dp[i] is not None:
                return dp[i]
            if s[i:] in wordDict:
                dp[i] = True
                return dp[i]

            for j in range(i, len(s)):
                if s[i:j + 1] in wordDict and dfs(j + 1):
                    dp[i] = True
                    return True
            
            dp[i] = False
            return dp[i]
            
        return dfs(0)
                
