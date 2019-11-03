package Companies.Cisco.FirstGo;

public class RotateImage {

    /**
     * You are given a n x n 2D matrix representing an image
     * Rotate the image by 90 degrees clockwise
     * NOTE: You have to rotate the image in-place.
     *
     */


    // Approach #1 Transpose and Reverse (Accepted, Time Complexity O(n^2), Space Complexity O(1)
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // transpose the matrix
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // reverse each row
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }


    }



    // Cleaner version
    public void rotateImage( int[][] matrix) {

        int n = matrix.length;
        Swap s = new Swap();

        // transpose the matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                s.swap(matrix[i][j],matrix[j][i]);
            }
        }

        // reverse each row
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                s.swap(matrix[i][j],matrix[i][n-j-1]);
            }
        }



    }
}

class Swap {

    public void swap(int first, int second) {

        int temp = first;
        first = second;
        second = temp;
    }
}
