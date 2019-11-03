package LinearProgress.Week4.Day7;


import java.util.HashSet;

// 9x9 sudoku
public class ValidSudoku {

    public boolean isValid(char[][] board) {
        for(int i=0; i <= 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cubes = new HashSet<>();
            for(int j=0;j<=9;j++) {

                // if there is a duplicate in the row
                if( board[i][j] != '.' && !rows.add(board[i][j])) return false;

                // if there is a duplicate in the columns
                if( board[i][j] != '.' && !columns.add(board[i][j])) return false;

                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);
                // if there is a duplicate in the cube
                if(board[rowIndex+j/3][colIndex+ j%3] != '.' &&
                        !cubes.add(board[rowIndex + j/3][colIndex + j%3])) return false;
            }
        }
        return false;



    }
}
