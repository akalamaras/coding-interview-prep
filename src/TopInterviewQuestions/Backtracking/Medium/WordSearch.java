package TopInterviewQuestions.Backtracking.Medium;

public class WordSearch {


    public boolean exist(char[][] board, String word) {

        char[] array = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtrack(board, i, j, array, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, char[] array, int index) {

        // Base case
        if(index == array.length)
            return true;

        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1)
            return false;

        if(board[i][j] != array[index])
            return false;

        // To save memory, apply bit mask on visited cells
        /*
        Let's consider cases:
            Case 1: a particular x, y is visited and it was not a matching letter
            during the last visit. This case we indeed want to revisit that node as it was not
            'consumed' for the solution.

            Case 2: the previously visited x,y was a match. Then applying the bit mask of 256
            (i.e. XOR with 0b100000000) would change that to a not match for any ASCII letter
            we consider. Hence it will always be false until we apply the XOR again to bring back
            the original letter (which by then we are done exploring the neighbors anyway)
         */
        board[i][j] ^= 256;
        boolean exists = backtrack(board, i, j + 1, array, index + 1)
                || backtrack(board, i, j - 1, array, index + 1)
                || backtrack(board,i + 1, j, array, index + 1)
                || backtrack(board, i - 1, j, array, index +1);
        board[i][j] ^= 256;
        return exists;

    }
}

