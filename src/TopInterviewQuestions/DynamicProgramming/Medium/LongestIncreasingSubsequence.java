package TopInterviewQuestions.DynamicProgramming.Medium;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int[] dpTable = new int[nums.length];

        dpTable[0] = 1;
        int maximum = 1;
        for(int i = 1; i < dpTable.length; i++) {

            int curMax = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    curMax = Math.max(curMax, dpTable[j]);
            }
            dpTable[i] = curMax + 1;
            maximum = Math.max(maximum, dpTable[i]);
        }
        return maximum;
    }
}

