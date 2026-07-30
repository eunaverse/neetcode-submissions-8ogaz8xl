class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        tmp = []

        def dfs(idx: int, curSum: int):
            if curSum > target:
                return
            
            if curSum == target:
                res.append(tmp[:])
                return
            if idx == len(nums):
                return


            tmp.append(nums[idx])
            dfs(idx, curSum + nums[idx])
            tmp.pop()
            dfs(idx+1, curSum)
        
        dfs(0,0)
        return res


