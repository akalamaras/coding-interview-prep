package LinearProgress.Week5.Day4;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValid(char[][] board) {
        for(int i=0; i<9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> squares = new HashSet<>();
            for(int j=0; j<9; j++) {
                // check unique rows
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                // check unique columns
                if(board[i][j] != '.' && !columns.add(board[i][j])) return false;
                // check unique squares
                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);
                if(board[rowIndex+ j/3][colIndex + j&3] != '.' &&
                    !squares.add(board[rowIndex + j/3][colIndex + j%3])) return false;
            }
        }
        return true;
    }
    // wrong?
}
