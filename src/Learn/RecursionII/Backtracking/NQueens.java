package Learn.RecursionII.Backtracking;

import java.util.*;

public class NQueens {

    public List<List<Integer>> nQueens(int n) {

        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<Integer>(), result);
        return result;

    }

    private static void solveNQueens(int n, int row, List<Integer> colPlacements, List<List<Integer>> result) {

        /** Our goal */
        if(row == n)
            result.add(new ArrayList<>(colPlacements));
        else {

            for(int col = 0; col < n; col++) {

                /** Our choice */
                colPlacements.add(col);

                /** Our constraints */
                if(isValid(colPlacements)) {
                    solveNQueens(n, row + 1, colPlacements, result);
                }

                /** Undoing our choice */
                colPlacements.remove(colPlacements.size()-1);
            }
        }
    }

    private static boolean isValid(List<Integer> colPlacements) {

        int rowId = colPlacements.size() - 1;

        for(int i = 0; i < rowId; i++) {

            int diff = Math.abs(colPlacements.get(i) - colPlacements.get(rowId));

            if(diff == 0 || diff == rowId - i)
                return false;

        }
        return true;
    }
}
