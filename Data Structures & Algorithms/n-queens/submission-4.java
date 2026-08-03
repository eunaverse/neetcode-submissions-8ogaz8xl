class Solution {

    int col, diag, diag2;
    char[][] board;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        res = new ArrayList<>();
        backtrack(0, n, board);
        return res;

    }

    void backtrack(int row, int n, char[][] board){
        if(row==n) {
            List<String> copy = new ArrayList<>();
            for(char[] rr : board){
                copy.add(new String(rr));
            }
            res.add(copy);
            return;
        }

        for(int i=0;i<n;i++){
            if((col&(1<<i))>0 ||(diag&(1<<(row+i)))>0 || (diag2&(1<<(row-i+n)))>0) continue;
            col^=(1<<i);
            diag^=(1<<(row+i));
            diag2^=(1<<(row-i+n));
            board[row][i]='Q';
            backtrack(row+1, n, board);
            board[row][i] = '.';
            col^=(1<<i);
            diag^=(1<<(row+i));
            diag2^=(1<<(row-i+n));
        }
    }
}
