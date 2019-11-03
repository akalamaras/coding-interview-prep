package LinearProgress.Week3.Day4;

public class RotateImageClockwise {

    private void rotate(int[][] matrix) {
        /*
         * clockwise rotate
         * first reverse up to down, then swap the symmetry i.e. transpose it
         * 1 2 3     7 8 9     7 4 1
         * 4 5 6  => 4 5 6  => 8 5 2
         * 7 8 9     1 2 3     9 6 3
         */
        int s = 0, e = matrix.length-1;
        // reverse
        while(s<e) {
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }
        // transpose
        for(int i=0; i<matrix.length; i++) {
            for(int j = i+1; j < matrix[i].length;  j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }



    }
}
