class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        l=0
        res = []
        q = deque()
        maxVal = -10001
        for r in range(len(nums)):
            while q and nums[q[-1]] < nums[r]:
                q.pop()
            q.append(r)

            while q and l > q[0]:
                q.popleft()
            if r-l+1 ==k:
                l+=1
                res.append(nums[q[0]])
            

        return res     