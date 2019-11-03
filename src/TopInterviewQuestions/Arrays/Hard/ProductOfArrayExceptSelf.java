package TopInterviewQuestions.Arrays.Hard;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        ProductOfArrayExceptSelf arrayProduct = new ProductOfArrayExceptSelf();
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        array = arrayProduct.dynamicProgramming(array);
        System.out.println(Arrays.toString(array));
    }

    // Brute Force
    public int[] bruteForce(int[] nums) {

        int[] result = new int[nums.length];

        for(int i = 0; i < result.length; i++)
            result[i] = findProduct(nums, 0, i - 1) * findProduct(nums, i + 1, nums.length - 1);
        return result;
    }

    private int findProduct(int[] nums, int left, int right) {

        if(right < left)
            return 1;

        int product = 1;
        for(int i = left; i <= right; i++)
            product *= nums[i];
        return product;
    }

    // Dynamic Programming
    public int[] dynamicProgramming(int[] nums) {

        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i < left.length; i++)
            left[i] = left[i - 1] * nums[i - 1];

        int[] right = new int[nums.length];
        right[right.length - 1] = 1;
        for(int i = right.length - 2; i >= 0; i--)
            right[i] = right[i + 1] * nums[i + 1];

        int[] product = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            product[i] = left[i] * right[i];

        return product;
    }
}
