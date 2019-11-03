package Companies.SAP;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int i = matrix.length-1;
        int j = 0;

        for(int k = 0; k < matrix.length + matrix[0].length; k++) {

            int current = matrix[i][j];

            if(current > target && i == 0)
                return false;

            if(current < target && j == matrix[0].length-1)
                return false;

            if(current == target)
                return true;

            if(current > target)
                i--;
            else
                j++;
        }
        return false;
    }
}
