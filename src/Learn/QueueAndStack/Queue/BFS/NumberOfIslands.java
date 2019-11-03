package Learn.QueueAndStack.Queue.BFS;

import java.util.*;


public class NumberOfIslands {


    public int numOfIslands(char[][] grid) {

        int number = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    number++;
                    bfs(grid, i, j);

                }

            }
        }
        return number;
    }

    public void bfs(char[][] grid, int i, int j) {

        grid[i][j] = '0';

        Queue<Integer> queue = new LinkedList<>();
        int code = i * grid[0].length + j;
        queue.offer(code);
        while (!queue.isEmpty()) {

            code = queue.poll();
            int x = code / grid[0].length;
            int y = code % grid[0].length;

            if (i > 0 && grid[x - 1][y] == '1') {             // up
                queue.offer((x - 1) * grid[0].length + y);
                grid[x - 1][y] = '0';
            }

            if (i < grid.length - 1 && grid[x + 1][y] == '1') {        // down
                queue.offer((x + 1) * grid[0].length + y);
                grid[x + 1][y] = '0';
            }

            if (j > 0 && grid[x][y - 1] == '1') {            // left
                queue.offer((x) * grid[0].length + y - 1);
                grid[x][y - 1] = '0';
            }

            if (j < grid[0].length && grid[x][y + 1] == '1') {         // right
                queue.offer((x) * grid[0].length + y + 1);
                grid[x][y + 1] = '0';
            }


        }

    }

}
