class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        ans = 0
        for i in range(len(heights)):
            w = 0
            while len(stack) > 0 and stack[-1][0] > heights[i]:
                w+=stack[-1][1]
                ans = max(ans, stack[-1][0] * w)
                stack.pop()
                
            stack.append([heights[i], w + 1])

        w = 0
        while len(stack)>0:
            top = stack.pop()
            w += top[1]
            ans = max(ans, w * top[0])
            
        
        return ans
                