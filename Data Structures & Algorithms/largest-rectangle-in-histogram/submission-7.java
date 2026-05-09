public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<Integer> stk = new Stack<>();

        for(int i=0;i<heights.length;i++){
                while(!stk.isEmpty() && heights[stk.peek()]>heights[i]){
                    int topIdx = stk.pop();
                    int width = i;
                    if(!stk.isEmpty()){
                        width = i - stk.peek() - 1;
                    }
                    maxArea = Math.max(maxArea, heights[topIdx] * width);
                }

            stk.push(i);
        } 

        while(!stk.isEmpty()){
            int topIdx = stk.pop();
            int width = heights.length;
            if(!stk.isEmpty()){
                width = heights.length - 1 - stk.peek();
            }

            maxArea = Math.max(maxArea, heights[topIdx]*width);
        }

        return maxArea;
    }
}