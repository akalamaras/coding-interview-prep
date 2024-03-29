package Companies.Goldman;

public class TrappingRainWater {

    public int trap(int[] height) {

        if(height == null || height.length == 0)
            return 0;

        int[] left = new int[height.length];
        left[0] = height[0];
        for(int i = 1; i < height.length; i++)
            left[i] = Math.max(height[i], left[i - 1]);


        int[] right = new int[height.length];
        right[right.length - 1] = height[height.length - 1];
        for(int i = right.length - 2; i >= 0; i--)
            right[i] = Math.max(height[i], right[i + 1]);

        int ans = 0;
        for(int i = 0; i < height.length; i++)
            ans += Math.min(left[i], right[i]) - height[i];

        return ans;
    }
}
