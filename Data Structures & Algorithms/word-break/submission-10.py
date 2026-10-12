class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * len(s)
        words = set(wordDict)
        for i in range(len(s)):
            if s[:i+1] in words:
                dp[i] = True
            else: 
                for j in range(i):
                    if dp[j] and s[j+1:i+1] in words:
                        dp[i] = True
                        break
        
        return dp[len(s) - 1]
                
