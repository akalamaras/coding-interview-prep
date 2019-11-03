package Companies.Apple.Recursion;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, word.toCharArray(), 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] wordArray, int currentIndex) {

        if(currentIndex == wordArray.length)
            return true;

        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return false;

        if(board[i][j] != wordArray[currentIndex])
            return false;

        board[i][j] ^= 256;
        boolean ans = dfs(board, i + 1, j, wordArray, currentIndex + 1) ||
                      dfs(board, i - 1, j, wordArray, currentIndex + 1) ||
                      dfs(board, i, j + 1, wordArray, currentIndex + 1) ||
                      dfs(board, i, j - 1, wordArray, currentIndex + 1);
        board[i][j] ^= 256;
        return ans;
    }
}
