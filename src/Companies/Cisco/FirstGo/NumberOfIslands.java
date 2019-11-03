package Companies.Cisco.FirstGo;

import java.util.*;

public class NumberOfIslands {

    /**
     *   Given a 2D grid of '1's (land) and '0's (water), count the number of islands.
     *   An island is surrounded by water by connecting adjacent lands horizontally and
     *   vertically. You may assume all 4 edges of the grid are surrounded by water
     */


    // Approach #1 DFS (Accepted, O(m*n) time complexity, O(m*n) space complexity)

    /*  Intuition: Treat the 2D map as an undirected graph and there is an edge between two
     *             horizontally or vertically adjacent nodes of value '1'.
     *
     *  Algorithm: Linear scan the 2D grid map, if a node contains a '1', then it is a root node
     *             that triggers a DFS. During DFS, every visited node should be as '0' to mark a
     *             visited node. Count the number of root nodes that trigger DFS, this number is
     *             the number of islands since each DFS identifies an island.
     */

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0')
            return;

        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    public int numIslands(char[][] grid) {

        if( grid == null || grid.length == 0)
            return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;
        for(int r = 0; r < nr; r++) {
            for(int c = 0; c < nc; c++) {
                if(grid[r][c] == '1') {
                    count++;
                    dfs(grid,r,c);
                }
            }
        }
        return count;
    }



    // Approach #2 BFS (Never in a million years)
    // (Accepted, O(m * n) time complexity, space complexity not sure)
    public int numIslandsBFS(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;


        for(int r = 0; r < nr; r++) {
            for(int c = 0; c < nc; c++) {
                if(grid[r][c] == '1') {
                    count++;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbours = new LinkedList<>();
                    neighbours.add(r * nc + c);
                    while (!neighbours.isEmpty()) {
                        int id = neighbours.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbours.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbours.add((row + 1) * nc + col);
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbours.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbours.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}
