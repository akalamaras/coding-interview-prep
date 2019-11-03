package TopInterviewQuestions.SortingAndSearching.Medium;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0)
            return false;

        int i = 0;
        int j = matrix[0].length - 1;

        for(int k = 0; k < matrix.length + matrix[0].length; k++) {

            if(i > matrix.length - 1 || j < 0)
                return false;

            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
