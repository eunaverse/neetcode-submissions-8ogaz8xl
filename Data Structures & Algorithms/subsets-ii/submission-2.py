class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()

        def dfs(idx: int):

            if idx == len(nums):
                res.append(tmp[:])
                return
            
            tmp.append(nums[idx])
            dfs(idx+1)
            tmp.pop()
            while idx+1 < len(nums) and nums[idx]==nums[idx+1]:
                idx+=1
            
            dfs(idx+1)
        tmp = []
        dfs(0)
        return res