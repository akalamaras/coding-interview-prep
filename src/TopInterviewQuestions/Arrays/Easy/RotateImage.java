package TopInterviewQuestions.Arrays.Easy;

public class RotateImage {

    /** Transpose and Invert */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        mirror(matrix);
    }

    private void transpose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void mirror(int[][] matrix) {
        for(int j = 0; j < matrix.length; j++) {
            int left = 0;
            int right = matrix.length-1;
            while (left < right) {
                int temp = matrix[j][left];
                matrix[j][left++] = matrix[j][right];
                matrix[j][right--] = temp;
            }

        }
    }
}
