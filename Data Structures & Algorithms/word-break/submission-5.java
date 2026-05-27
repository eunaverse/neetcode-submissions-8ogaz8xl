 class Solution {
          public boolean wordBreak(String s, List<String> wordDict) {
                   int[] memo = new int[s.length()]; // 0: 미방문, 1: 실패, 2: 성공
                    
                             return dfs(s, new HashSet<>(wordDict), 0, memo);
                                  }
                                   
                                        boolean dfs(String s, Set<String> wordDict, int idx, int[] memo) {
                                                 if (idx >= s.length()) return true;
                                                          if (memo[idx] != 0) return memo[idx] == 2;
                                                           
                                                                    for (int i = idx + 1; i <= s.length(); i++) {
                                                                                 if (wordDict.contains(s.substring(idx, i))) {
                                                                                                  if (dfs(s, wordDict, i, memo)) {
                                                                                                                       memo[idx] = 2;
                                                                                                                                            return true;
                                                                                                                                                             }
                                                                                                                                                                          }
                                                                                                                                                                                   }
                                                                                                                                                                                    
                                                                                                                                                                                             memo[idx] = 1;
                                                                                                                                                                                                      return false;
                                                                                                                                                                                                           }
                                                                                                                                                                                                            }
