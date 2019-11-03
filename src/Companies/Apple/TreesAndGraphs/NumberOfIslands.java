package Companies.Apple.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1)
            return;

        if(grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public int numIslandsIterative(char[][] grid) {

        int count = 0;

        if(grid == null || grid.length == 0)
            return count;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == '1') {

                    count++;
                    grid[i][j] = '0';
                    queue.add(i * grid[0].length + j);

                    while(!queue.isEmpty()) {

                        int id = queue.poll();

                        int x = id / grid[0].length;
                        int y = id % grid[0].length;

                        if(x - 1 >= 0 && grid[x - 1][y] == '1') {
                            queue.add((x - 1) * grid[0].length + y);
                            grid[x - 1][y] = '0';
                        }
                        if(x + 1 <= grid.length - 1 && grid[x + 1][y] == '1') {
                            queue.add((x + 1) * grid[0].length + y);
                            grid[x + 1][y] = '0';
                        }
                        if(y - 1 >= 0 && grid[x][y - 1] == '1') {
                            queue.add(x * grid[0].length + y - 1);
                            grid[x][y - 1] = '0';
                        }
                        if(y + 1 <= grid.length - 1 && grid[x][y + 1] == '1') {
                            queue.add(x * grid[0].length + y + 1);
                            grid[x][y + 1] = '0';
                        }



                    }
                }
            }
        }
        return count;
    }


}
