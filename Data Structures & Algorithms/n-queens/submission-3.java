class Solution {

    boolean[] col, diag, diag2;
    char[][] board;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        // col[n]
        // diag[n]
        col = new boolean[n];
        diag = new boolean[2*n];
        diag2 = new boolean[2*n];

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
            if(col[i] || diag[row-i+n-1]|| diag2[row+i]) continue;
            col[i] = true;
            diag[row-i+n-1] = true;
            diag2[row+i] = true;
            board[row][i] = 'Q';
            backtrack(row+1, n, board);
            board[row][i] = '.';
            col[i] = false;
            diag[row-i+n-1] = false;
            diag2[row+i] = false;
        }
    }
}
