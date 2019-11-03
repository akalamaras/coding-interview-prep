package Learn.RecursionII.DivideAndConquer;

public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int i = 0;
        int j = matrix[0].length-1;

        for(int k = 0; k < matrix.length + matrix[0].length; k++) {

            int current = matrix[i][j];

            if(current > target && j == 0)
                return false;

            if(current > target && i == matrix.length-1)
                return false;

            if(current == target)
                return true;

            if(current > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
