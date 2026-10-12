class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * len(s)
        for i in range(len(s)):
            if s[:i+1] in wordDict:
                dp[i] = True
            else: 
                for j in range(i):
                    if dp[j] and s[j+1:i+1] in wordDict:
                        dp[i] = True
                        break
        
        return dp[len(s) - 1]
                
