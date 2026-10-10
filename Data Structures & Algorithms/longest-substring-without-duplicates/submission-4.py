class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        num = {}

        l, r  = (0, 0)
        res = 0

        for r in range(len(s)):
            if s[r] in num and num[s[r]] >= l:
                l = num[s[r]] + 1
            num[s[r]] = r
            res = max(res, r-l+1)
        
        return res

        