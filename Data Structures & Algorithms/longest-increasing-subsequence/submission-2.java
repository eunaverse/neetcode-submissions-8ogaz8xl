 class Solution {
       int ans;
        
             public int lengthOfLIS(int[] nums) {
                      int[] dp = new int[nums.length]; // dp[i]: length of substring i ~ nums.length-1
                               dfs(nums, dp, 0, -1001);
                                        return ans;
                                             }
                                              
                                                   int dfs(int[] nums, int[] dp, int idx, int pre) {
                                                            if (idx == nums.length) return 0;
                                                                     if (dp[idx] > 0) return dp[idx];
                                                                      
                                                                               for (int i = idx; i < nums.length; i++) {
                                                                                            if (pre >= nums[i]) continue;
                                                                                                         dp[idx] = Math.max(dp[idx], dfs(nums, dp, i + 1, nums[i]) + 1);
                                                                                                                  }
                                                                                                                   
                                                                                                                            ans = Math.max(ans, dp[idx]);
                                                                                                                                     return dp[idx];
                                                                                                                                          }
                                                                                                                                           }

 