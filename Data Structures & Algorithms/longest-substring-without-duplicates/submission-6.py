class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, r = 0, 0
        maxLen = 0
        words = defaultdict(int)
        while r < len(s):
            if s[r] in words and words[s[r]] > 0:
                while s[l] != s[r]:
                    words[s[l]] -= 1
                    l+=1
                words[s[l]] -= 1
                l+=1
            maxLen = max(maxLen, r - l + 1)
            words[s[r]] += 1
            r+=1
        
        return maxLen