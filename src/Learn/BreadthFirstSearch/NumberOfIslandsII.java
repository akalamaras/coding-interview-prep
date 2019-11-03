package Learn.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> list = new ArrayList<>();
        int current = 0;
        int[][] grid = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isInsertPosition(positions, i, j)) {
                    grid[i][j] = 1;

                    if(isIsland(grid, i, j))
                        current++;

                    list.add(current);
                }
            }
        }
        return list;
    }

    private boolean isInsertPosition(int[][] positions, int x, int y) {

        for(int i = 0; i < positions.length; i++) {
            if(positions[i][0] == x && positions[i][1] == y)
                return true;
        }
        return false;
    }

    private boolean isIsland(int[][] grid, int i, int j) {

        if(i - 1 >= 0 && grid[i - 1][j] == 1)
            return false;

        if(i + 1 <= grid.length - 1 && grid[i + 1][j] == 1)
            return false;

        if(j - 1 >= 0 && grid[i][j - 1] == 1)
            return false;

        if(j + 1 <= grid[0].length - 1 && grid[i][j + 1] == 1)
            return false;

        return true;
    }
}
