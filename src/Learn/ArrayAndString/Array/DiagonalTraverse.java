package Learn.ArrayAndString.Array;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0)
            return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;

        int[] ret = new int[m*n];
        int row = 0, col = 0, d = 0;
        // directions : diagonally down and up
        int[][] directions = {{-1,1},{1,-1}};

        for(int i = 0; i < m*n; i++) {
            ret[i] = matrix[row][col];
            row += directions[d][0];
            col += directions[d][1];


            // out of bottom order
            if (row >= m) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            }

            // out of right order
            if (col >= n) {
                row += 2;
                col = n - 1;
                d = 1 - d;
            }

            // out of top order
            if (row < 0) {
                row = 0;
                d = 1 - d;
            }

            // out of left order
            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }
        return ret;

    }
}
