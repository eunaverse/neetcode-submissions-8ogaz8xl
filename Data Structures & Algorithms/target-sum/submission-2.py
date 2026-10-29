class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = [defaultdict(int) for _ in range(len(nums)+1)]
        def dfs(i, total):
            if i==len(nums):
                return 1 if total == target else 0
            
            if total in dp[i]:
                return dp[i][total]
            
            dp[i][total] += dfs(i+1, total + nums[i]) + dfs(i+1, total-nums[i])

            return dp[i][total]
        return dfs(0,0)
                

        