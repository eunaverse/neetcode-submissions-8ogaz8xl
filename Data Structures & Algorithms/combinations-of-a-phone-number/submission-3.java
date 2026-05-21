 class Solution {
             Map<String, List<String>> nMap = Map.of("2", List.of("a", "b", "c"), "3", List.of("d", "e", "f"), "4", List.of("g", "h", "i"), "5", List.of("j", "k", "l"), "6", List.of("m", "n", "o"), "7", List.of("p", "q", "r", "s"), "8", List.of("t", "u", "v"), "9", List.of("w","x", "y", "z"));
              
                   List<String> ans = new ArrayList<>();
                    
                         public List<String> letterCombinations(String digits) {
                        if(digits.isEmpty()) return ans;
                                  backtrack(digits, 0, new StringBuilder());
                                           return ans;
                                                }
                                                 
                                                      void backtrack(String digits, int idx, StringBuilder sb) {
                                                               if (idx == digits.length()) {
                                                                            ans.add(sb.toString());
                                                                            return;
                                                                                                  }
                                                                                                   
                                                                                                            String digit = String.valueOf(digits.charAt(idx));
                                                                                                                     List<String> alp = nMap.getOrDefault(digit, Collections.EMPTY_LIST);
                                                                                                                              for (String ss : alp) {
                                                                                                                                           backtrack(digits, idx + 1, sb.append(ss));
                                                                                                                                                        sb.deleteCharAt(sb.length() - 1);
                                                                                                                                                                 }
                                                                                                                                                                  
                                                                                                                                                                       }
                                                                                                                                                                        }

 