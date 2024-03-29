package TopInterviewQuestions.Arrays.Hard;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        if(height == null || height.length == 0)
            return 0;

        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(left <= right) {

            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
