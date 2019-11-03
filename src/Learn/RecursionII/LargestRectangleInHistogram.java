package Learn.RecursionII;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    private int calculateArea(int[] heights, int left, int right) {

        // Base case
        if(left > right)
            return 0;


        // Find minimum
        int minIndex = left;
        for(int i = left; i <= right; i++) {
            if (heights[minIndex] > heights[i])
                minIndex = i;
        }

        // Split the problem in 2 + the current
        int currentSubproblem = heights[minIndex] * (right - left + 1);
        int leftSubproblem = calculateArea(heights, left, minIndex - 1);
        int rightSubproblem = calculateArea(heights, minIndex + 1, right);

        // return the maximum
        return(Math.max(currentSubproblem, Math.max(leftSubproblem, rightSubproblem)));
    }
}
