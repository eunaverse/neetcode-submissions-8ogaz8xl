class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [float('inf')] * n

        def dfs(idx) -> int:
            if idx >= n - 1:
                return 0
            if nums[idx] == 0:
                return float('inf')
            
            if dp[idx]!=float('inf'):
                return dp[idx]
            
            for step in range(nums[idx]):
                dp[idx] = min(dp[idx], 1+dfs(idx+step+1))
            
            return dp[idx]
        return dfs(0)