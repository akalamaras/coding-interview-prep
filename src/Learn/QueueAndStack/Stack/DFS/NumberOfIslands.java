package Learn.QueueAndStack.Stack.DFS;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int number = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    number++;
                    dfs(grid, i, j);
                }
            }
        }
        return number;
    }


    public void dfs(char[][] grid, int i, int j) {

        if(grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        if( i > 0)
            dfs(grid,i-1,j);
        if( i < grid.length-1)
            dfs(grid,i+1,j);
        if( j > 0)
            dfs(grid,i,j-1);
        if( j < grid[0].length-1)
            dfs(grid,i,j+1);
    }
}
