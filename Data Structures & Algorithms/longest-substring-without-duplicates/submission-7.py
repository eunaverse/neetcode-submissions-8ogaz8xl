class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, r = 0, 0
        maxLen = 0
        words = set()
        while r < len(s):
            if s[r] in words:
                while s[l] != s[r]:
                    words.remove(s[l])
                    l+=1
                words.remove(s[l])
                l += 1
            maxLen = max(maxLen, r - l + 1)
            words.add(s[r])
            r+=1
        
        return maxLen