package Companies.Apple.TreesAndGraphs;

public class LongestIncreasingPathMatrix {

    public int longestIncreasingPath(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int cur = dfs(matrix, i, j, Integer.MIN_VALUE, cache);
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int previous, int[][] cache) {

        if(i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1)
            return 0;

        int current = matrix[i][j];

        if(current <= previous)
            return 0;

        // Memoization
        if(cache[i][j] != 0)
            return cache[i][j];

        int a = dfs(matrix, i + 1, j, current, cache) + 1;
        int b = dfs(matrix, i - 1, j, current, cache) + 1;
        int c = dfs(matrix, i, j + 1, current, cache) + 1;
        int d = dfs(matrix, i, j - 1, current, cache) + 1;

        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;

        return max;
    }
}
