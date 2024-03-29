package TopInterviewQuestions.DynamicProgramming.Easy;

public class MaximumSubarray {

    public int maxSub(int[] nums) {

        int currentSum = nums[0];
        int maximumSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i],currentSum + nums[i]);
            maximumSum = Math.max(maximumSum,currentSum);
        }

        return maximumSum;
    }
}
