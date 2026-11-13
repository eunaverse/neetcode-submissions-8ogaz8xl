class Solution:
    def canJump(self, nums: List[int]) -> bool:
        dp = {} 

        def dfs(idx: int) -> bool:
            if idx >= len(nums) - 1:
                return True
            if idx in dp:
                return dp[idx]
            dp[idx] = False
            for i in range(nums[idx]):
                dp[idx] = dfs(idx+i+1)
                if dp[idx]:
                    return True
            return dp[idx]
        
        return dfs(0)
