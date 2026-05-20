 class Solution {
           List<List<Integer>> res = new ArrayList<>();
            
                 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
                          Arrays.sort(candidates);
                           
                                    backtrack(candidates, target, 0, new ArrayList<>());
                                             return res;
                                                  }
                                                   
                                                        void backtrack(int[] candidates, int sum, int idx, List<Integer> temp) {
                                                                 if (sum < 0) return;
                                                                          if (sum == 0) {
                                                                                       res.add(new ArrayList<>(temp));
                                                                                                    return;
                                                                                                             }
                                                                                                              
                                                                                                                       for (int i = idx; i < candidates.length; i++) {
                                                                                                                                    if (i != idx && candidates[i] == candidates[i - 1]) continue;
                                                                                                                                                 temp.add(candidates[i]);
                                                                                                                                                              backtrack(candidates, sum - candidates[i], i + 1, temp);
                                                                                                                                                                           temp.removeLast();
                                                                                                                                                                                    }
                                                                                                                                                                                         }
                                                                                                                                                                                          }

 
