 class Solution {
           public int numDecodings(String s) {
                    int dp1 = 0, dp2 = 0;
                             // dp1 -> dp[i-1]
                                      // dp2 -> dp[i-2]
                                               // 1 ~ 26
                                                        // dp[i] = 0~i  decoded ways
                                                         
                                                                  if (s.charAt(0) == '0') return 0;
                                                                           dp1 = 1;
                                                                                    for (int i = 1; i < s.length(); i++) {
                                                                                                 char curChar = s.charAt(i);
                                                                                                              char preChar1 = s.charAt(i - 1);
                                                                                                                           int dp = 0;
                                                                                                                                        if (curChar != '0') dp = dp1;
                                                                                                                                                     if (!(preChar1 == '1' || (preChar1 == '2' && curChar <= '6'))) {
                                                                                                                                                                      if (curChar == '0') return 0;
                                                                                                                                                                                   } else {
                                                                                                                                                                                                    if (i > 1) dp += dp2;
                                                                                                                                                                                                                     else dp += 1;
                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                               dp2 = dp1;
                                                                                                                                                                                                                                                            dp1 = dp;
                                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                               return dp1;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                     }
