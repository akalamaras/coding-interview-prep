package LinearProgress.Week1.Day3;

public class MaximumSubarray {

    // O(n) time, O(n) space
    private int maxSubarray(int[] nums) {

        int[] dp = new int[nums.length];
        int max =  nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    // O(n) time, O(1) space
    private int advanced(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int index : nums) {
            sum = Math.max(sum, 0) + index;
            res = Math.max(res, sum);
        }
        return res;
    }

    public int worksWithProductsAsWell(int[] A) {
        if(A == null || A.length == 0) return 0;
        int max = A[0], min = A[0], result = A[0];
        for(int i=1;i<A.length;i++) {
            int temp = max;
            max = Math.max(Math.max(temp + A[i], min + A[i]), A[i]);
            min = Math.min(Math.min(temp + A[i], min + A[i]), A[i]);
            if(max > result) result = max;
        }
        return result;
    }



    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        int[] array = {-2,1,5,-7,4,3,2,-2,1};
        System.out.println(m.maxSubarray(array));
        System.out.println(m.advanced(array));
    }
}
