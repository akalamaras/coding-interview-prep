package Learn.ArrayAndString.Array;

public class LargestNumberAtLeastTwice {

    public int dominantIndex(int[] nums) {

        if(nums == null || nums.length == 0)
            return -1;

        if(nums.length == 1)
            return 0;

        int max = nums[0], second = nums[0];
        int maxIndex = 0;

        for(int i = 1; i < nums.length; i++) {
            if( nums[i] > max) {
                second = max;
                max = nums[i];
                maxIndex = i;
            } else if ( nums[i] > second && nums[i] < max) {
                second = nums[i];
            }
        }
        if( max >= 2*second)
            return maxIndex;
        return -1;
    }
}
