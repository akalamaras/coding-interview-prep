package Companies.Cisco.SecondGo.ArraysAndStrings;

public class MaximumSubarray {

    public int maxSubarray(int[] nums) {

        int current = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}
