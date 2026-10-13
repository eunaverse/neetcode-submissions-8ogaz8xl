class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # dp[i][0]: i번 날이 시작되었을 때 주식 보유 X
        # dp[i][1]: i번 날이 시작되었을 때 주식 보유

        dp = [[0]*2 for _ in range(len(prices)+1)]
        dp[0][1] = float("-inf")

        for i in range(1,len(prices)+1):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i-1])
            pre = dp[i-2][0] if i>=2 else 0
            dp[i][1] = max(dp[i-1][1], pre - prices[i-1])
        
        return max(dp[-2][0], dp[-2][1] + prices[-1])


