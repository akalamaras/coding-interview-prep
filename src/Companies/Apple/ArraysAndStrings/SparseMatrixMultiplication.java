package Companies.Apple.ArraysAndStrings;

public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {

        int m = A.length;
        int n = A[0].length;

        int nB = B[0].length;

        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {

                if(A[i][k] != 0) {
                    for(int j = 0; j < nB; j++) {
                        if(B[k][j] != 0)
                            C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }

    public int[][] multiply2(int[][] A, int[][] B) {

        if (A == null || A.length == 0)
            return A;

        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < B[0].length; k++) {
                    res[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return res;
    }
}
