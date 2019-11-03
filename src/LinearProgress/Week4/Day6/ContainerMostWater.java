package LinearProgress.Week4.Day6;

public class ContainerMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, maxArea = 0;
        while(left<right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea) maxArea = area;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerMostWater cmw = new ContainerMostWater();
        System.out.println(cmw.maxArea(array));
    }
}
