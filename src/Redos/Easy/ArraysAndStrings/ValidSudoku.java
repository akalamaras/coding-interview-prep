package Redos.Easy.ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {


    public boolean isValidSudoku(char[][] board) {



        for(int i = 0; i < board.length; i++) {

            Set<Character> rows  = new HashSet<>();
            Set<Character> cols  = new HashSet<>();
            Set<Character> cubes = new HashSet<>();

            for(int j = 0; j < board[0].length; j++) {


                if(board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;

                if(board[j][i] != '.' && !cols.add(board[j][i]))
                    return false;

                int cubeI = 3*(i / 3) + j / 3;
                int cubeJ = 3*(i % 3) + j % 3;

                if(board[cubeI][cubeJ] != '.' && !cubes.add(board[cubeI][cubeJ]))
                    return false;
            }
        }
        return true;
    }
}
