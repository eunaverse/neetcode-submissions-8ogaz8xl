class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num: nums){
            total += num;
        }
        if(total%2==1) return false;

        int sum = total/2;
        boolean[][] dp = new boolean[nums.length][sum+1];
        
        return dfs(0, nums, 0, sum, dp);
    }

    boolean dfs(int cur, int[] nums, int sum, int target, boolean[][] dp){
        if(sum==target) return true;
        if(sum>target||cur >= nums.length) return false;
        if(dp[cur][sum]) return dp[cur][sum];

        dp[cur][sum] = dfs(cur+1, nums, sum+nums[cur], target, dp);
        if(dp[cur][sum]) return true;
        dp[cur][sum] = dfs(cur+1, nums, sum, target, dp);
        
        return  dp[cur][sum];
    }
}
