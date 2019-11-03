package Learn.RecursionII.Backtracking;

public class SudokuSolver {

    private int n; // box size
    private int N; // row size

    private int[][] rows;
    private int[][] columns;
    private int[][] boxes;

    private char[][] board;

    private boolean sudokuSolved;

    public SudokuSolver() {

        n = 3;
        N = n * n;

        rows = new int[N][N + 1];
        columns = new int[N][N + 1];
        boxes = new int[N][N + 1];

        sudokuSolved = false;
    }

    public void solveSudoku(char[][] board) {

        this.board = board;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {

                char num = board[i][j];
                if(num != '.')
                    placeNumber(Character.getNumericValue(num), i, j);
            }
        }
        backtrack(0, 0);
    }

    private void backtrack(int row, int col) {

        // if the cell is empty
        if(board[row][col] == '.') {
            // iterate from 1 to 9
            for(int d = 1; d < 10; d++) {

                if(couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);

                    // backtrack if we haven't finished
                    if(!sudokuSolved)
                        removeNumber(d, row, col);
                }

            }
        } else
            placeNextNumbers(row, col);

    }

    private boolean couldPlace(int d, int row, int col) {

        int index = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[index][d] == 0;
    }

    private void placeNumber(int d, int row, int col) {

        int index = (row / n) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[index][d]++;

        board[row][col] = (char)(d + '0');
    }

    private void removeNumber(int d, int row, int col) {

        int index = (row / n) * n + col / n;

        rows[row][d]--;
        columns[col][d]--;
        boxes[index][d]--;

        board[row][col] = '.';
    }

    private void placeNextNumbers(int row, int col) {

        /** Goal state */
        if(col == N - 1 && row == N - 1)
            sudokuSolved = true;
        else if(col == N - 1)
            backtrack(row + 1, 0);
        else
            backtrack(row, col + 1);
    }
}
