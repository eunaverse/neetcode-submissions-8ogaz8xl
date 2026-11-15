class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # dp[i][0]: i번 날이 끝났을 떄 주식 보유 X
        # dp[i][1]: i번 날이 끝났을 때 주식 보유

        dp = [[0]*2 for _ in range(len(prices)+1)]
        dp[0][1] = float("-inf")

        for i in range(1,len(prices)+1):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i-1])
            pre = dp[i-2][0] if i>=2 else 0
            dp[i][1] = max(dp[i-1][1], pre - prices[i-1])
        
        return max(dp[len(prices)][0], dp[len(prices)][1])
