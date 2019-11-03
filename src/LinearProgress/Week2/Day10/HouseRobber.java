package LinearProgress.Week2.Day10;

public class HouseRobber {

    private int rob(int[] nums) {
        int ifDidntRobPrevious = 0;
        int ifRobbedPrevious = 0;
        for (int house : nums) {
            int currentRobbed = ifDidntRobPrevious + house;
            int currentNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);
            ifDidntRobPrevious = currentNotRobbed;
            ifRobbedPrevious = currentRobbed;
        }
        return Math.max(ifDidntRobPrevious, ifRobbedPrevious);
    }

    public static void main(String[] args) {

        int[] array = {1,2,3,1};
        HouseRobber h = new HouseRobber();
        System.out.println(h.rob(array));
    }
}
