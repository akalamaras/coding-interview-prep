package TopInterviewQuestions.DynamicProgramming.Medium;

public class IncreaseTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {

        if(nums == null || nums.length < 3)
            return false;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for(int i = 0; i < nums.length; i++) {

            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);

            }
            if(dp[i] >=3)
                return true;
        }
        return false;
    }
}
