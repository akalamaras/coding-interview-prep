package TopInterviewQuestions.DynamicProgramming.Easy;

public class HouseRobber {

    public int rob(int[] houses) {

        int previousMax = 0;
        int currentMax = 0;

        for(int n : houses) {

            int temp = currentMax;
            currentMax = Math.max(previousMax + n, currentMax);
            previousMax = temp;
        }
        return currentMax;
    }
}
