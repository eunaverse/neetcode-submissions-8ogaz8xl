class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        idx = 0
        merged = False
        for interval in intervals:
            if newInterval[1] < interval[0]:
                if not merged:
                    res.append(newInterval)
                    merged = True
                res.append(interval)
            elif interval[1] < newInterval[0]:
                res.append(interval)
            elif interval[1] >= newInterval[0]:
                newInterval = [min(newInterval[0], interval[0]), max(newInterval[1], interval[1])]
        
        if not merged:
            res.append(newInterval)
        return res