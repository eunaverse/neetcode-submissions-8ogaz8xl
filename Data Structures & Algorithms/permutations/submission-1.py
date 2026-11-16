class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def dfs(perm: List[int], mask: int):
            if len(perm) == len(nums):
                res.append(perm.copy())
                return
            
            for i in range(len(nums)):
                if not (mask & (1 << i)):
                    perm.append(nums[i])
                    dfs(perm, mask | (1<<i))
                    perm.pop()
        dfs([], 0)
        return res