package Companies.Goldman;

public class MinimumSizeSubarraySum {

    public int minSubarrayLen(int s, int[] nums) {

        int j = 0, min = Integer.MAX_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s && j < nums.length) {
                min = Math.min(min, i - j + 1);
                sum -= nums[j++];
            }
        }
        if(sum >= s)
            min = Math.min(min, nums.length - j);

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
