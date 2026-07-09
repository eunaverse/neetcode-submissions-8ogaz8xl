class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        ans = 0
        for i in range(len(heights)):
            while len(stack) > 0 and heights[stack[-1]] > heights[i]:
                top = stack.pop()
                w = i if not stack else i - stack[-1] - 1
                ans = max(ans, heights[top] * w)
                
            stack.append(i)

        while len(stack)>0:
            top = stack.pop()
            w = len(heights) if not stack else len(heights) - stack[-1] - 1
            ans = max(ans, w * heights[top])
            
        
        return ans
                