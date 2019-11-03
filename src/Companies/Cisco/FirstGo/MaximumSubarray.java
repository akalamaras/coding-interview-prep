package Companies.Cisco.FirstGo;

public class MaximumSubarray {


    /**
     *  Given an array, find the contiguous subarray (containing at least one number) which has the
     *  largest sum and return its sum.
     *
     *  E.g. :  Input:        [-2,1,-3,4,-1,2,1,-5,4]
     *          Output:       6
     *          Explanation:  [4,-1,2,1] has the largest sum = 6
     *
     *  Follow up: If you have figured out the O(n) solution, try coding another solution
     *             using the divide and conquer approach, which is more subtle
     *
     */

    // Even more approaches : https://leetcode.com/articles/sliding-window-maximum/

    // Approach #1 Greedy Algorithm (Accepted, O(n) time complexity, O(1) space complexity)

    // Pick the locally optimal move at each step, which will lead to a globally optimal solution
    public int maxSubarray(int[] nums) {
        int currentSum = nums[0], maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    // Approach #2 Divide and Conquer

    /* (Accepted, O(nlogn)* time complexity, O(logn)** space complexity)
     *
     * * : We divide the problem in halves every time and do liner work each time therefore nlogn.
     *
     * ** : O(logn) space complexity because of the recursion stack.
     */

    /*
     * maxSubarray for array of n numbers:
     *     - If n == 1 return this single element
     *     - leftSum = maxSubarray for the left subarray i.e. for the first n/2 numbers
     *           (middle element at index (left + right) / 2 always belongs to the left subarray)
     *     - rightSum = maxSubarray for the right subarray i.e. for the last n/2 numbers
     *     - crossSum = maximum sum of the subarray containing elements from both left and right
     *            sub arrays and hence crossing the middle element at index (left + right) / 2.
     *     - Merge the sub problem solutions i.e. return Math.max(leftSum,rightSum,crossSum).
     */
    public int maxSubarrayDC(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public int helper(int[] nums, int left, int right) {

        if(left == right) return nums[left];

        int p = (left + right) / 2;

        int leftSum = helper(nums,left,p);
        int rightSum = helper(nums,p+1,right);
        int crossSum = crossSum(nums,left,right,p);
        return Math.max(crossSum, Math.max(leftSum,rightSum));
    }

    public int crossSum(int[] nums, int left, int right, int p) {

        if(left == right) return nums[left];

        int leftSubSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; i--) {
            currSum += nums[i];
            leftSubSum = Math.max(leftSubSum,currSum);
        }

        int rightSubSum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p+1; i <= right; i++) {
            currSum += nums[i];
            rightSubSum = Math.max(rightSubSum,currSum);
        }

        return rightSubSum + leftSubSum;
    }

    // Approach #3 Dynamic Programming (Kadane's Algorithm)
    //      (Accepted, O(n) time complexity, O(1) space complexity)

    /*
     * Modify the array to track the current local maximum and update the global maximum sum accordingly
     */
    public int maxSubarrayDP(int[] nums) {
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] > 0)
                nums[i] += nums[i-1];
            maxSum = Math.max(nums[i],maxSum);
        }
        return maxSum;
    }
}
