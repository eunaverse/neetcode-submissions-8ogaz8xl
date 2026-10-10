class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l = 0
        maxFreq = 0
        res = 0
        nums = {}
        for r in range(len(s)):
            nums[s[r]] = nums.get(s[r],0) + 1

            maxFreq = max(maxFreq, nums[s[r]])
            window = r - l + 1
            while window - maxFreq > k:
                nums[s[l]] = nums[s[l]] - 1
                l+=1
                window = r - l + 1
            res = max(res, r- l +1)
        
        return res
        