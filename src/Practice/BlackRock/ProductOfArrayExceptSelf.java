package Practice.BlackRock;

import java.util.Collections;

public class ProductOfArrayExceptSelf {

    public int[] productArrayExceptSelf(int[] nums) {

        int prod = 1;
        for(int n: nums)
            prod *= n;

        for(int i = 0; i < nums.length; i++)
            nums[i] = prod / nums[i];

        return nums;
    }

    public int[] productArrayExceptSelf2(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int[] ans = new int[nums.length];

        left[0] = 1;
        for(int i = 1; i < nums.length; i++)
            left[i] = nums[i - 1] * left[i - 1];

        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--)
            right[i] = nums[i + 1] * right[i + 1];

        for(int i = 0; i < nums.length; i++)
            ans[i] = left[i] * right[i];

        return ans;


    }
}
