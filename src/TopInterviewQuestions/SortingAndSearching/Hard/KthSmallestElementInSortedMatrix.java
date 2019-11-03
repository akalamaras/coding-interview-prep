package TopInterviewQuestions.SortingAndSearching.Hard;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int current = 1;
        int i = 0, j = 0;
        while(current + matrix.length < k) {
            current = current + 3;
            i++;
        }
        while(current < k) {
            current++;
            j++;
        }
        return matrix[i][j];
    }
}
