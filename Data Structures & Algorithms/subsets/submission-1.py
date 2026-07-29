class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(idx: int):
            if idx == len(nums):
                res.append(tmp[:])  # Make a copy
                return

            # Include nums[idx]
            tmp.append(nums[idx])
            dfs(idx + 1)
            tmp.pop()

            # Exclude nums[idx]
            dfs(idx + 1)

        tmp = []
        dfs(0)
        return res