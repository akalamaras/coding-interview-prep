package Redos.Medium.ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(rows.contains(i) || cols.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {

        int MODIFIED = -1000000;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                if(matrix[i][j] == 0) {

                    for(int k = 0; k < matrix.length; k++) {
                        if(matrix[k][j] != 0)
                            matrix[k][j] = MODIFIED;
                    }

                    for(int k = 0; k < matrix[0].length; k++) {
                        if(matrix[i][k] != 0)
                            matrix[i][k] = MODIFIED;
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                if(matrix[i][j] == MODIFIED)
                    matrix[i][j] = 0;
            }
        }
    }

    public void setZeroes3(int[][] matrix) {

        boolean isCol = false;

        // isCol marks if the first column should be set to 0, while
        // matrix[0][0] marks whether the first row should be set to 0.

        for(int i = 0; i < matrix.length; i++) {

            if(matrix[i][0] == 0)
                isCol = true;

            for(int j = 1; j < matrix[0].length; j++) {

                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {

                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(matrix[0][0] == 0) {
            for(int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }

        if(isCol) {
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}
