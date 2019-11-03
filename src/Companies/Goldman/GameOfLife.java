package Companies.Goldman;

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {

                int livesNearby = aliveNeighbours(board, i, j);

                // Rules
                if(board[i][j] == 1 && (livesNearby == 2 || livesNearby == 3))
                    board[i][j] = 3; // 01 -> 11

                if(board[i][j] == 0 && livesNearby == 3)
                    board[i][j] = 2; // 00 -> 01
            }
        }

        // Change the state
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int aliveNeighbours(int[][] board, int i, int j) {

        int lives = 0;
        for (int x = Math.max(0, i - 1); x <= Math.min(board.length - 1, i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(board[0].length - 1, j + 1); y++) {
                if (x != i || y != j)
                    lives += board[x][y] & 1;
            }
        }
        return lives;
    }
}
