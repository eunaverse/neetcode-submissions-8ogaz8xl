class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int j = first; j < last; j++) {
                int offset = j - first;

                int top = matrix[first][j];

                // left -> top
                matrix[first][j] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[j][last];

                // top -> right
                matrix[j][last] = top;
            }
        }
    }
}