class Solution {
    public int trap(int[] height) {
        int cumul = 0;
        int res = 0;
        int h = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0) h = height[i];
            else {
                if (h <= height[i]) {
                    res += cumul;
                    h = height[i];
                    cumul = 0;
                } else {
                    cumul += h - height[i];
                }
            }
        }

        cumul = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) h = height[i];
            else {
                if (h < height[i]) {
                    res += cumul;
                    h = height[i];
                    cumul = 0;
                } else {
                    cumul += h - height[i];
                }
            }
        }

        return res;
    }
}
