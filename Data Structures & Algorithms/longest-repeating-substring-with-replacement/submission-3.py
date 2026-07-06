class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        word = {}

        l = 0
        maxCount = 0
        res = 0
        for r in range(len(s)):
            word[s[r]] = word.get(s[r], 0) + 1
            maxCount = max(maxCount, word[s[r]])
            while (r - l + 1) - maxCount > k:
                word[s[l]]-=1
                l+=1
            # 왼쪽 문자 제거
            # left 이동
            res = max(res, r - l + 1)
        return res