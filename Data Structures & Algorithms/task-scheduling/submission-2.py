class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # A x x x A x x x A -> (maxFreq - 1) * (n+1) + maxCount
        count = [0] * 26

        for t in tasks:
            count[ord(t) - ord('A')] +=1
        
        maxFreq = max(count)
        maxCount = 0
        for c in count:
            maxCount+=1 if c == maxFreq else 0
        
        return max(len(tasks), (maxFreq - 1) * (n+1) + maxCount)