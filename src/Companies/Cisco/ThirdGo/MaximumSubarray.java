package Companies.Cisco.ThirdGo;

public class MaximumSubarray {

    // Greedy
    public int maxSubarray(int[] nums) {

        int current = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(current, max);
        }
        return max;
    }

    // Dynamic Programming (Kadane's Algorithm)
    public int maxSubarray2(int[] nums) {

        int[] table = nums.clone();
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(table[i - 1] > 0)
                table[i] += table[i - 1];

            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }
}
