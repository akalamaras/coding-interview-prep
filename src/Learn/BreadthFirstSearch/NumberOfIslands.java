package Learn.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int count = 0;
        Queue<Integer> neighbours = new LinkedList<>();

        if (grid == null || grid.length == 0)
            return count;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {

                    count++;
                    grid[i][j] = '0';

                    neighbours.add(i * grid[0].length + j);
                    while (!neighbours.isEmpty()) {

                        int id = neighbours.poll();
                        int row = id / grid[0].length;
                        int col = id % grid[0].length;

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbours.add((row - 1) * grid[0].length + col);
                            grid[row - 1][col] = '0';
                        }

                        if (row + 1 <= grid.length - 1 && grid[row + 1][col] == '1') {
                            neighbours.add((row + 1) * grid[0].length + col);
                            grid[row + 1][col] = '0';
                        }

                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbours.add(row * grid[0].length + col - 1);
                            grid[row][col - 1] = '0';
                        }

                        if (col + 1 <= grid[0].length - 1 && grid[row][col + 1] == '1') {
                            neighbours.add(row * grid[0].length + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;


    }
}