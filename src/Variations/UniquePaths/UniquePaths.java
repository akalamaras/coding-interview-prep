package Variations.UniquePaths;

public class UniquePaths {

    class DP {

        public int uniquePaths(int m, int n) {

            if(m == 0 || n == 0)
                return 0;

            Integer[][] map = new Integer[m][n];

            // Populate first row with 1
            for(int i = 0; i < m; i++)
                map[i][0] = 1;

            // Populate first column with 1
            for(int j = 0; j < n; j++)
                map[0][j] = 1;

            for(int i = 1; i < m; i++)
                for(int j = 1; j < n; j++)
                    map[i][j] = map[i-1][j] + map[i][j-1];

            return map[m-1][n-1];
        }
    }









    // Backtracking solution

    private int count = 0;

    public int uniquePaths(int m, int n) {

        backtrack(1, 1, m, n);
        return count;
    }

    private void backtrack(int currentM, int currentN, int m, int n) {

        if(currentM == m && currentN == n) {
            count++;
            return;
        }

        if(currentM < m)
            backtrack(currentM + 1, currentN, m, n);
        if(currentN < n)
            backtrack(currentM, currentN + 1, m, n);
    }
}
