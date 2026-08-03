class Solution {

    int col, diag, diag2;
 
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {

        int[] tmp = new int[n];
        res = new ArrayList<>();
        backtrack(0, n, tmp);
        return res;

    }

    void backtrack(int row, int n, int[] tmp){
        if(row==n) {
            List<String> board = new ArrayList<>();
            for(int i=0;i<n;i++){
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[tmp[i]] = 'Q';

                board.add(new String(line));
            }
            res.add(board);
            return;
        }

        for(int i=0;i<n;i++){
            if((col&(1<<i))>0 ||(diag&(1<<(row+i)))>0 || (diag2&(1<<(row-i+n)))>0) continue;
            col^=(1<<i);
            diag^=(1<<(row+i));
            diag2^=(1<<(row-i+n));
            tmp[row]=i;
            backtrack(row+1, n, tmp);

            col^=(1<<i);
            diag^=(1<<(row+i));
            diag2^=(1<<(row-i+n));
        }
    }
}
