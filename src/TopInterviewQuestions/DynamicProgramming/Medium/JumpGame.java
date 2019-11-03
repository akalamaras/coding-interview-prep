package TopInterviewQuestions.DynamicProgramming.Medium;

public class JumpGame {

    public boolean canJump(int[] nums) {

        int max = 0;
        for(int i = 0; i < nums.length; i++) {

            if(i > max)
                return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {

        int maxIndex = nums.length - 1;
        int maxJump = nums[0];

        for(int i = 0; i <= maxJump; i++) {

            maxJump = Math.max(maxJump, i + nums[i]);
            if(maxJump >= maxIndex)
                return true;
        }
        return false;
    }

    public boolean canJump3(int[] nums) {

        int furthest = 0;
        for(int i = 0; i < nums.length; i++) {
            
            if(furthest < i)
                return false;
            if(furthest >= nums.length - 1)
                return true;

            furthest = Math.max(furthest, i + nums[i]);
        }
        return true;
    }
}
