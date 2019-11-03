package Companies.Bloomberg.ArraysAndStrings;

public class CandyCrush {

    /**
     *  Implement a basic elimination algorithm for Candy Crush.
     *
     *  Given a 2D integer array 'board' representing a grid of candy, different positive integers
     *  grid[i][j] represent different types of candy.
     *  A value of board[i][j] = 0 represents that the cell position (i,j) is empty.
     *  The given board represents the state of the game following the player's move.
     *
     *  Now, you need to restore the board to a stable state by crushing candy according to
     *  the following rules:
     *    - If three or more candy of the same type are adjacent vertically or horizontally, "crush"
     *    them all at the same time. These positions become empty.
     *    - After crushing all candies simultaneously, if an empty space on the board has candies on
     *    top of itself, then these candies will drop until they hit a candy or the bottom at the same
     *    time. (No candies will drop outside the top boundary)
     *    - After the above steps, there may exist more candy that can be crushed. If so, you need to
     *    repeat the above steps.
     *    - If there does not exist more candies that can be crushed (i.e. the board is stable), then
     *    return the current board.
     *
     *
     *    You need to perform the above rules until the board becomes stable, then return the current
     *    board.
     */

    private boolean isStable;

    public int[][] candyCrush(int[][] board) {
        board = flagCandy(board);
        board = gravity(board);
        return (isStable) ? board : candyCrush(board);
    }

    public int[][] flagCandy(int[][] board) {
        for(int row = 0; row < board.length; row++) {
            for (int column = 0; column + 2 < board[0].length; column++) {

                int typeOfCandy = Math.abs(board[row][column]);

                if (typeOfCandy != 0 && typeOfCandy == Math.abs(board[row][column + 1])
                        && typeOfCandy == Math.abs(board[row][column + 2])) {
                    board[row][column] = board[row][column + 1] = board[row][column + 2] = -typeOfCandy;
                    isStable = false;
                }
            }
        }

        for(int row = 0; row+2 < board.length; row++) {
            for(int column = 0; column < board[0].length; column++) {

                int typeOfCandy = Math.abs(board[row][column]);

                if(typeOfCandy != 0 && typeOfCandy == Math.abs(board[row+1][column])
                        && typeOfCandy == Math.abs(board[row+2][column])) {
                    board[row][column] = board[row+1][column] = board[row+2][column] = - typeOfCandy;
                    isStable = false;
                }
            }
        }
        return board;
    }

    public int[][] gravity(int[][] board) {

        for(int column = 0; column < board[0].length; column++) {
            int wr = board.length-1;
            for(int row = board.length-1; row >= 0; --row) {
                if(board[row][column] > 0)
                    board[wr--][column] = board[row][column];
                while( wr >= 0)
                    board[wr--][column] = 0;
            }
        }
        return board;
    }
}
