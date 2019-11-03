package Companies.Goldman;

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {

        int[] current = {0, 0};
        for(char move : moves.toCharArray()) {
            switch(move) {
                case 'D' : current[0]++; break;
                case 'U' : current[0]--; break;
                case 'R' : current[1]++; break;
                case 'L' : current[1]--; break;
            }
        }
        return current[0] == 0 && current[1] == 0;
    }
}
