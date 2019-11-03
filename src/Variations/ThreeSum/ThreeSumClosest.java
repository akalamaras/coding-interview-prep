package Variations.ThreeSum;

import java.util.*;

public class ThreeSumClosest {

    /**
     * Given an array nums of n integers and an integer target, find three
     * integers in nums such that the sum is closest to target. Return the
     * sum of the three integers. You may assume that each input would have exactly one solution.
     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target)
                    left++;
                else
                    right--;
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }
}
