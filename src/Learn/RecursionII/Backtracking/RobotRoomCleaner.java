package Learn.RecursionII.Backtracking;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

    interface Robot {

        public boolean move();

        public void turnLeft();
        public void turnRight();

        public void clean();
    }


    public void cleanRoom(Robot robot) {

        Set<String> set = new HashSet<>();
        /** Directions are modeled as such:
         *    0   - up
         *    90  - right
         *    180 - down
         *    270 - left
         */
        int direction = 0;
        backtrack(robot, set, 0, 0, direction);
    }

    private void backtrack(Robot robot, Set<String> set, int i, int j, int direction) {

        String temp = i + "->" + j;

        if (set.contains(temp))
            return;

        robot.clean();
        set.add(temp);

        for (int k = 0; k < 4; k++) {

            if (robot.move()) {

                /** Find next cell based on current direction */
                int x = i;
                int y = j;

                switch (direction) {
                    case 0:
                        // go up, reduce x
                        x = i - 1;
                        break;
                    case 90:
                        // go right, increase y
                        y = j + 1;
                        break;
                    case 180:
                        // go down, increase x
                        x = i + 1;
                        break;
                    case 270:
                        // go left, reduce y
                        y = j - 1;
                        break;
                    default:
                        break;
                }

                backtrack(robot, set, x, y, direction);

                /** Undo your choice, go back to the starting position */
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            /** Turn to the next direction */
            robot.turnRight();
            direction += 90;
            direction %= 360;
        }
    }
}
