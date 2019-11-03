package Variations.UniquePaths;

public class UniquePathsII {

    class DP {

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            // If you start on an obstacle, return 0
            if(obstacleGrid[0][0] == 1)
                return 0;

            // Number of ways of reaching the starting cell = 1
            obstacleGrid[0][0] = 1;

            // Fill the first column
            for(int i = 1; i < obstacleGrid.length; i++) {
                if (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1)
                    obstacleGrid[i][0] = 1;
                else
                    obstacleGrid[i][0] = 0;
            }

            // Fill the first row
            for(int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1)
                    obstacleGrid[0][j] = 1;
                else
                    obstacleGrid[0][j] = 0;
            }

            for(int i = 1; i < obstacleGrid.length; i++) {
                for(int j = 1; j < obstacleGrid[0].length; j++) {

                    // If it is not an obstacle
                    if(obstacleGrid[i][j] == 0)
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                    else
                        obstacleGrid[i][j] = 0;
                }
            }
            return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        }
    }

    private int count = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;

        backtrack(0, 0, obstacleGrid);
        return count;

    }

    private void backtrack(int currentI, int currentJ, int[][] grid) {

        if(currentI == grid.length - 1 && currentJ == grid[0].length - 1) {
            count++;
            return;
        }

        if(currentI < grid.length - 1 && grid[currentI + 1][currentJ] != 1)
            backtrack(currentI + 1, currentJ, grid);

        if(currentJ < grid[0].length - 1 && grid[currentI][currentJ + 1] != 1)
            backtrack(currentI, currentJ + 1, grid);
    }
}
