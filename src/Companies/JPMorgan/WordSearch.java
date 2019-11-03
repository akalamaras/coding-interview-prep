package Companies.JPMorgan;

public class WordSearch {


    public boolean exist(char[][] board, String word) {

        boolean[][] boolMatrix = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolMatrix = reset(boolMatrix);
                if(dfs(board,i,j,word,boolMatrix))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String remWord,boolean[][] matrix) {
        if(remWord.length() == 1 && board[i][j] == remWord.charAt(0))
            return true;

        if(board[i][j] == remWord.charAt(0)) {

            matrix[i][j] = true;


            boolean right = (i < board.length-1) && (matrix[i+1][j]) &&
                    dfs(board,i+1,j,remWord.substring(1),matrix);

            boolean left = (i > 0) &&  (matrix[i-1][j]) &&
                    dfs(board,i-1,j,remWord.substring(1),matrix);

            boolean down = (j < board[0].length-1) && (matrix[i][j+1]) &&
                    dfs(board,i,j+1,remWord.substring(1),matrix);

            boolean up = (j > 0) &&
                    (matrix[i][j-1]) &&  dfs(board,i,j-1,remWord.substring(1),matrix);



            return(up || down || left || right);
        }
        else
            return false;
    }

    private boolean[][] reset (boolean[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = false;
        }
        return matrix;

    }
}
