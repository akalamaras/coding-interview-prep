package Learn.RecursionII.Backtracking;

public class WordSearch {

    public boolean wordSearch(char[][] board, String word) {

        int index = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {

                if(backtrack(board, i, j, word.toCharArray(), index))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, char[] array, int index) {

        if(index == array.length)
            return true;

        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return false;

        if(board[i][j] != array[index])
            return false;

        board[i][j] ^= 256;
        boolean ans =  backtrack(board, i + 1, j, array, index + 1)
            || backtrack(board, i - 1, j, array, index + 1)
            || backtrack(board, i, j + 1, array, index + 1)
            || backtrack(board, i, j - 1, array, index + 1);
        board[i][j] ^= 256;

        return ans;
    }
}
