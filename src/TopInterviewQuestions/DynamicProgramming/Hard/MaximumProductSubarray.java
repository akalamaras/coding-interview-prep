package TopInterviewQuestions.DynamicProgramming.Hard;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int result = nums[0];
        int max = result, min = result;

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);

            result = Math.max(result, max);
        }
        return result;
    }

}
