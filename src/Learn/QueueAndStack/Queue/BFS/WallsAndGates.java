package Learn.QueueAndStack.Queue.BFS;

import java.util.*;

/**
 *  You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
 *   represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
 *   it should be filled with INF.
 *
 */

public class WallsAndGates{


    public void wallsAndGates(int[][]rooms) {

        Queue<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {

                if (rooms[i][j] == 0)
                    queue.add(new Integer[]{i, j});
            }

        }

        while (!queue.isEmpty()) {

            Integer[] top = queue.poll();
            int row = top[0], col = top[1];

            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new Integer[]{row - 1, col});
            }

            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new Integer[]{row + 1, col});
            }

            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new Integer[]{row, col - 1});
            }

            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new Integer[]{row, col + 1});
            }


        }


    }
}