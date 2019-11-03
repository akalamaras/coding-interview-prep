package LinearProgress.Week5.Day1;


// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

import java.util.*;

public class SetMatrixZeroes {



    // Additional memory approach
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        // find the rows that are to be converted to 0
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        // iterate over the array again and update the elements
        for(int i=0; i < R; i++) {
            for(int j=0; j< C; j++) {
                if(rows.contains(i) || columns.contains(j)) matrix[i][j] = 0;
            }
        }

    }


}
