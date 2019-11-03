package TopInterviewQuestions.Arrays.Easy;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] cost) {

        Arrays.sort(cost, (a, b) -> (a[0] - a[1])- (b[0] - b[1]));

        int total = 0, n = cost.length / 2;
        for(int i = 0; i < n; i++)
            total += cost[i][0] + cost[i + n][1];
        return total;
    }
}
