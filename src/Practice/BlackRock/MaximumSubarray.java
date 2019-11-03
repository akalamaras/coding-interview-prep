package Practice.BlackRock;

public class MaximumSubarray {

    public int maxSubarray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public int kadanes(int[] nums) {

        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {

            if(nums[i - 1] > 0)
                nums[i] +=  nums[i - 1];

            maxSum += Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
