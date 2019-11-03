package Companies.JPMorgan;

public class MaximumSubarray {

    public int maxSubarray(int[] nums) {

        int max = nums[0], current = nums[0];
        for(int i =1; i < nums.length; i++) {
            current = Math.max(nums[i],nums[i]+current);
            max = Math.max(max,current);
        }
        return max;
    }
}
