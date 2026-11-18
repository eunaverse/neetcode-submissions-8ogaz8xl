class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = nums[0]
        min_val, max_val = 1, 1

        for num in nums:
            tmp = max_val * num
            max_val = max(max_val * num, min_val * num, num)
            min_val = min(tmp, min_val * num, num)
            res = max(max_val, res)
        return res