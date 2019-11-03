package Companies.Apple.ArraysAndStrings;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trap = new TrappingRainWater();
        System.out.println(trap.trapWater(heights));
    }

    // Brute Force
    public int trapWater(int[] height) {

        int ans = 0;
        for(int i = 0; i < height.length; i++) {

            int maxLeft = 0;
            int maxRight = 0;

            for(int j = i; j >= 0; j--)
                maxLeft = Math.max(maxLeft, height[j]);

            for(int j = i; j < height.length; j++)
                maxRight = Math.max(maxRight, height[j]);

            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    // Dynamic Programming
    public int trap(int[] height) {

        if(height == null || height.length == 0)
            return 0;

        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        leftMax[0] = height[0];
        for(int i = 1; i < size; i++)
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);

        rightMax[size - 1] = height[size - 1];
        for(int i = size - 2; i >= 0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);

        int ans = 0;
        for(int i = 1; i < size - 1; i++)
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];

        return ans;
    }

    // 2 Pointers
    public int waterTrap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int ans = 0;
        while(left < right) {

            if(height[left] < height[right]) {

                if(height[left] >= leftMax)
                    leftMax = height[left];
                else
                    ans += leftMax - height[left];

                left++;
            } else {

                if(height[right] >= rightMax)
                    rightMax = height[right];
                else
                    ans += rightMax - height[right];

                right--;
            }
        }
        return ans;
    }
}
