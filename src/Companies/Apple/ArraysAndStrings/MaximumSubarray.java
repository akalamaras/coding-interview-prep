package Companies.Apple.ArraysAndStrings;

public class MaximumSubarray {

    public static void main(String[] args) {

        int[] array = {-1, 0, 1, 4, -3, 2, 5, 1, -10, 11};
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubarray(array));
    }

    public int maxSubarray(int[] nums) {

        int currentSum = nums[0];
        int maximumSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }
}
