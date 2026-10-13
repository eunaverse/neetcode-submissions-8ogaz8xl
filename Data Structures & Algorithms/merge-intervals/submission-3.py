class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        if len(intervals) == 1:
            return intervals
        intervals.sort()
        newInterval = intervals[0]
        for interval in intervals[1:]:
            if newInterval[0] > interval[1]:
                res.append(interval)
            elif newInterval[1] < interval[0]:
                res.append(newInterval)
                newInterval = interval
            elif newInterval[0] <= interval[1]:
                newInterval = [min(interval[0], newInterval[0]), max(interval[1],newInterval[1])]
        

        res.append(newInterval)
        return res
