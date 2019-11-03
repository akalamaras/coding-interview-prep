package Companies.Goldman;

public class MinimumPathSolution {

    public int minPathSumDP(int[][] grid) {

        int[][] table = new int[grid.length][grid[0].length];

        // First Row
        table[grid.length -1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        for(int j = grid[0].length - 2; j >= 0; j--)
            table[grid.length - 1][j] = grid[grid.length -1][j] + table[grid.length - 1][j + 1];

        for(int i = grid.length - 2; i >= 0; i--) {
            for(int j = grid[0].length -1; j >= 0; j--) {
                if(j == grid[0].length - 1)
                    table[i][j] = grid[i][j] + table[i + 1][j];
                else
                    table[i][j] = grid[i][j] + Math.min(table[i + 1][j] , table[i][j + 1]);
            }
        }
        return table[0][0];
    }

    public int minPathSum(int[][] grid) {

        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        backtrack(grid, 0, 0, 0, min);
        return min[0];
    }

    private void backtrack(int[][] grid, int i, int j, int sum, int[] min) {

        if(i == grid.length || j == grid[0].length)
            return;

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            min[0] = Math.min(min[0], sum + grid[i][j]);
            return;
        }

        backtrack(grid, i + 1, j, sum + grid[i][j], min);
        backtrack(grid, i, j + 1, sum + grid[i][j], min);
    }
}
