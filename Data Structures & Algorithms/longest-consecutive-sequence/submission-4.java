class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int prev = 0;
        int res = 0, count = 0;
        int idx = 0;

        while(idx < nums.length){
            int num = nums[idx];
            if(idx==0 || prev == num - 1) {
                count += 1;
            }
            else{
                res = Math.max(res, count);
                count = 1;
            }
            prev = num;
            idx++;
            while(idx < nums.length && prev == nums[idx]){
                idx++;
            }
        }
res = Math.max(res, count);
        return res;
    }
}
