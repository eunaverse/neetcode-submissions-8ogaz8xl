class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = 101
        res = 0
        for p in prices:
            if buy < p:
                res = max(res, p - buy)
            else:
                buy = p
        
        return res
        