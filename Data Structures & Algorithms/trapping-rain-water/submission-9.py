class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        stack = []
        res = 0

        for i in range(len(height)):
            while stack and height[i] >= height[stack[-1]]:
                mid = height[stack.pop()]
                if stack:
                    left = height[stack[-1]]
                    right = height[i]

                    h = min(left, right) - mid
                    w = i - stack[-1] - 1
                    res += w * h
            stack.append(i)
        
        return res