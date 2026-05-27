 class Solution {
          public int numDecodings(String s) {
                   int[] dp = new int[s.length()];
                            // 1 ~ 26
                                     // dp[i] = 0~i  decoded ways
                                      
                                               if (s.charAt(0) == '0') return 0;
                                                        dp[0] = 1;
                                                                 for (int i = 1; i < s.length(); i++) {
                                                                              char curChar = s.charAt(i);
                                                                                           char preChar1 = s.charAt(i - 1);
                                                                                                        if (curChar != '0') dp[i] = dp[i - 1];
                                                                                                                     if (!(preChar1 == '1' || (preChar1 == '2' && curChar <= '6'))) {
                                                                                                                                      if (curChar == '0') return 0;
                                                                                                                                                   } else {
                                                                                                                                                                    if (i > 1) dp[i] += dp[i - 2];
                                                                                                                                                                                     else dp[i] += 1;
                                                                                                                                                                                                  }
                                                                                                                                                                                                   
                                                                                                                                                                                                            }
                                                                                                                                                                                                             
                                                                                                                                                                                                                      return dp[s.length() - 1];
                                                                                                                                                                                                                       
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                             }
