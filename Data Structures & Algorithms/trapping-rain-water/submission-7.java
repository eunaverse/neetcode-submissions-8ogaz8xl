class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        
        int leftMax = height[l], rightMax = height[r];
        while(l<r){
           if(leftMax<rightMax){
            l++;
            if(leftMax<height[l]){
                leftMax=height[l];
            }
            else{
                res += leftMax - height[l];
            }
           }
           else{
            r--;
            if(rightMax<height[r]){
                rightMax=height[r];
            }
            else{
                res += rightMax - height[r];
            }
           }
        }
    

        return res;
    }
}