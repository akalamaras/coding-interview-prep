package TopInterviewQuestions.Design.Medium;

// O(n)
class TicTacToe {

    private int[][] grid;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        grid = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return 0;

        if(grid[row][col] != 0)
            return 0;

        grid[row][col] = player;

        if(checkVerticalWin(col, player) || checkHorizontalWin(row, player) || checkDiagonalWin(row, col, player))
            return player;

        return 0;
    }

    private boolean checkVerticalWin(int col, int player) {

        for(int i = 0; i < grid.length; i++) {
            if(grid[i][col] != player)
                return false;
        }
        return true;
    }

    private boolean checkHorizontalWin(int row, int player) {

        for(int j = 0; j < grid[0].length; j++) {
            if(grid[row][j] != player)
                return false;
        }
        return true;
    }

    private boolean checkDiagonalWin(int row, int col, int player) {

        if (row != col && row + col != grid.length - 1)
            return false;

        boolean topLeftToBottomRight = true;
        boolean topRightToBottomLeft = true;

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] != player)
                topLeftToBottomRight = false;
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid.length - 1 - i] != player)
                topRightToBottomLeft = false;
        }
        return topRightToBottomLeft || topLeftToBottomRight;


    }

}

// O(1)
class TicTacToe2 {

    private int[] rows;
    private int[] cols;
    private int topLeftBottomRight;
    private int topRightBottomLeft;

    public TicTacToe2(int n) {
        rows = new int[n];
        cols = new int[n];
        topLeftBottomRight = 0;
        topRightBottomLeft = 0;
    }

    public int move(int row, int col, int player) {

        rows[row] += player == 1 ? 1 : - 1;
        cols[col] += player == 1 ? 1 : - 1;

        if(row == col)
            topLeftBottomRight += player == 1 ? 1 : -1;

        if(row + col == rows.length - 1)
            topRightBottomLeft += player == 1 ? 1 : -1;

        if(rows[row] == rows.length || cols[col] == cols.length
                || topLeftBottomRight == rows.length || topRightBottomLeft == rows.length)
            return -1;

        if(rows[row] == -rows.length || cols[col] == -cols.length
                || topLeftBottomRight == - rows.length || topRightBottomLeft == - rows.length)
            return 2;

        return 0;
    }

}

class TicTacToe3 {


    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToe3(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {

        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;

        if (row == col)
            diagonal += toAdd;

        if (col == cols.length - row - 1)
            antiDiagonal += toAdd;


        int size = rows.length;
        if (Math.abs(rows[row]) == size
                || Math.abs(cols[col]) == size
                || Math.abs(diagonal) == size
                || Math.abs(antiDiagonal) == size)
            return player;

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
