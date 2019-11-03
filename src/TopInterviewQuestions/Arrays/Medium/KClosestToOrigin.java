package TopInterviewQuestions.Arrays.Medium;

import java.util.Arrays;

public class KClosestToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        int[] distances = new int[points.length];
        for(int i = 0; i < points.length; i++)
            distances[i] = findDistance(points[i]);

        Arrays.sort(distances);
        int largest = distances[K - 1];

        int[][] ans = new int[K][2];
        for(int i = 0, t = 0; i < points.length; i++) {
            if(findDistance(points[i]) <= largest)
                ans[t++] = points[i];
        }
        return ans;
    }


    private int findDistance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
