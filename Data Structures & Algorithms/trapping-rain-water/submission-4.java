class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        int l = 0;
        int wall = 0;

        for (int r = 1; r < n; r++) {
            if (height[r] >= height[l]) {
                res += (r - l - 1) * height[l] - wall;
                l = r;
                wall = 0;
            } else {
                wall += height[r];
            }
        }

        int rightBoundary = l;

        int r = n - 1;
        wall = 0;

        for (l = n - 2; l >= rightBoundary; l--) {
            if (height[l] >= height[r]) {
                res += (r - l - 1) * height[r] - wall;
                r = l;
                wall = 0;
            } else {
                wall += height[l];
            }
        }

        return res;
    }
}