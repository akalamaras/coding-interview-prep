package Learn.RecursionII.Backtracking;

import java.util.*;

public class NQueensII {

    public int totalNQueens(int n) {

        int[] rows = new int[n];
        // 'hill' diagonals
        int[] hills = new int[4 * n - 1];
        // 'dale' diagonals
        int[] dales = new int[2 * n - 1];

        return backtrack(0, 0, n, rows, hills, dales);
    }

    private int backtrack(int row, int count, int n, int[] rows, int[] hills, int[] dales) {

        for(int col = 0; col < n; col++) {

            if(notUnderAttack(row, col, n, rows, hills, dales)) {
                // place queen
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;
                dales[row + col] = 1;

                if(row + 1 == n)
                    count++;
                else
                    count = backtrack(row + 1, count, n, rows, hills, dales);

                // remove queen
                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }
        return count;
    }

    private boolean notUnderAttack(int row, int col, int n, int[] rows, int[] hills, int[] dales) {

        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return res == 0;
    }
}
