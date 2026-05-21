 class Solution {
          List<List<String>> ans = new ArrayList<>();
           
                public List<List<String>> solveNQueens(int n) {
                         backtrack(0, n, 0, 0, 0, new int[n]);
                                  return ans;
                                       }
                                        
                                             /*
                                                  1 1 1
                                                       1 1 1
                                                            1 1 1 (n-1 + n-1 + 3 - 2n)
                                                                (0,2), (1,1) , (2,0) -> row + col
                                                                    (1,2), (2,1) -> row + col
                                                                        (0,0),(1,1), (2,2) -
                                                                            (1,0) , (2,1) -> row - col
                                                                                (0,1) , (1,2) -> row - col + n - 1
                                                                                    row + 1, col + 1
                                                                                         */
                                                                                          
                                                                                               void backtrack(int row, int n, int colVisited, int diagVisited1, int diagVisited2, int[] tmp) {
                                                                                                        if (n == row) {
                                                                                                                     ans.add(buildBoard(tmp, n));
                                                                                                                                  return;
                                                                                                                                           }
                                                                                                                                            
                                                                                                                                                     for (int col = 0; col < n; col++) {
                                                                                                                                                                  int colBit = 1 << col;
                                                                                                                                                                               int diagBit1 = 1 << (row + col);
                                                                                                                                                                                            int diagBit2 = 1 << (row - col + n - 1);
                                                                                                                                                                                             
                                                                                                                                                                                                          if ((colBit & colVisited) != 0 || (diagBit1 & diagVisited1) != 0 || (diagBit2 & diagVisited2) != 0)
                                                                                                                                                                                                                           continue;
                                                                                                                                                                                                                                        tmp[row] = col;
                                                                                                                                                                                                                                                     backtrack(row + 1, n, colVisited | colBit, diagVisited1 | diagBit1, diagVisited2 | diagBit2, tmp);
                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                          List<String> buildBoard(int[] queens, int n) {
                                                                                                                                                                                                                                                                                   List<String> board = new ArrayList<>();
                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                             for (int i = 0; i < n; i++) {
                                                                                                                                                                                                                                                                                                          char[] line = new char[n];
                                                                                                                                                                                                                                                                                                                       Arrays.fill(line, '.');
                                                                                                                                                                                                                                                                                                                                    line[queens[i]] = 'Q';
                                                                                                                                                                                                                                                                                                                                                 board.add(new String(line));
                                                                                                                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                                                                                                                                   return board;
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                         }
