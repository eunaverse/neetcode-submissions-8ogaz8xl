 class Solution {
          public int numDecodings(String s) {
                   int[] dp = new int[s.length()];
                            // 1 ~ 26
                             
                                      return dfs(s, 0, dp);
                                           }
                                            
                                                 int dfs(String s, int idx, int[] dp) {
                                                          if (idx == s.length()) return 1;
                                                                   if (dp[idx] > 0 || s.charAt(idx) == '0') return dp[idx];
                                                                    
                                                                             dp[idx] = dfs(s, idx + 1, dp);
                                                                                      if (idx + 1 < s.length() && (s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6'))
                                                                                                   dp[idx] += dfs(s, idx + 2, dp);
                                                                                                    
                                                                                                             return dp[idx];
                                                                                                                  }
                                                                                                                   
                                                                                                                    }
