package TopInterviewQuestions.Arrays.Hard;

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        if(board == null || board.length == 0)
            return;

        int rowLen = board.length;
        int colLen = board[0].length;

        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {

                int lives = aliveNeighbours(board, i, j, rowLen, colLen);

                // Rules
                if(board[i][j] == 1 && (lives == 2 || lives == 3))
                    board[i][j] = 3; // 01 -> 11

                if(board[i][j] == 0 && lives == 3)
                    board[i][j] = 2; // 00 -> 01
            }
        }

        // Change the state
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                board[i][j] >>= 1;
            }
        }


    }

    private int aliveNeighbours(int[][] board, int i, int j, int rowLen, int colLen) {

        int lives = 0;

        for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, rowLen - 1); x++) {
            for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, colLen - 1); y++) {
                if(x != i || y != j)
                    lives += board[x][y] & 1;
            }
        }
        return lives;
    }
}
