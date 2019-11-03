package Learn.ArrayAndString.TwoPointer;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int current = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 1)
                current++;
            else {
                if(current > max)
                    max = current;
                current = 0;
            }
        }
        if(current > max)
            max = current;
        return max;
    }
}
