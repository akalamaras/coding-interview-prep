package TopInterviewQuestions.DynamicProgramming.Medium;

public class UniquePaths {

    private int count;

    public int uniquePaths(int m, int n) {

        if(m == 0 || n == 0)
            return 0;

        Integer[][] map = new Integer[m][n];

        // Populate the first row
        for(int i = 0; i < m; i++)
            map[i][0] = 1;

        // Populate first column
        for(int i = 0; i < n; i++)
            map[0][i] = 1;

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}
