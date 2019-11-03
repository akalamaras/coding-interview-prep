package Variations.TwoSum;

import java.util.Arrays;

public class TwoSumLessThanK {

    /**
     *  Given an array A of integers and integer K, return the maximum S such that there
     *  exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
     *
     */

    /** Approach #1 Binary Search
     *
     * O(nlogn) time and O(1) space */
    public int twoSumLessThanK(int[] nums, int K) {
        Arrays.sort(nums);
        int max = -1;

        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum < K) {
                max = Math.max(max, sum);
                left++;
            } else
                right--;
        }
        return max;
    }
}
