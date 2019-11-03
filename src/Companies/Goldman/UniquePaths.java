package Companies.Goldman;

public class UniquePaths {

    public static void main(String[] args) {

        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(6, 4));
    }

    public int uniquePathsDP(int m, int n) {

        int[][] table = new int[m][n];

        for(int i = 0; i < m; i++)
            table[i][0] = 1;

        for(int j = 0; j < n; j++)
            table[0][j] = 1;

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {

        int[] ans = new int[1];
        backtrack(0, 0, m, n, ans);
        return ans[0];
    }

    private void backtrack(int i, int j, int m, int n, int[] ans) {

        if(i == n || j == m)
            return;

        if(i == n - 1 && j == m - 1) {
            ans[0]++;
            return;
        }

        backtrack(i + 1, j, m, n, ans);
        backtrack(i, j + 1, m, n, ans);
    }
}
