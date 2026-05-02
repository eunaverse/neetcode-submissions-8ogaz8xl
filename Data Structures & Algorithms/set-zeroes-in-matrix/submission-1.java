class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                   matrix[0][j]=0;
                   if(i>0){
                    matrix[i][0]=0;
                   }
                   else{
                    rowZero = true;
                   }
                }
            }
        }

        int ROWS = matrix.length, COLS = matrix[0].length;
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int r = 0; r < ROWS; r++) {
                matrix[r][0] = 0;
            }
        }

         if (rowZero) {
            for (int c = 0; c < COLS; c++) {
                matrix[0][c] = 0;
            }
        }

    }
}
