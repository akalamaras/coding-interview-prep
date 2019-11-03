package Companies.Cisco.FirstGo;

import java.util.*;

/**
 *  Given an array of n integers, are there elements a,b,c such that a+b+c = 0?
 *  Find all unique triplets in the array which gives the sum of 0.
 *
 *  Note: The solution set must not contain duplicate triplets.
 *
 *  Example.  Input:     [-1,0,1,2,,-1,4]
 *            Output:    [ [-1,0,1],[-1,-1,2]]
 */

public class ThreeSum {


    // Approach #1 Best (Accepted, O(n^2) time complexity, O(1) space complexity)

    /*
     * Time Complexity: O(nlogn) for sorting the array,
     *                  We do O(n) work for n elements(all possible first elements of a triplet)
     *                  O(n^2) + O(nlogn) = O(n^2)
     *
     * Space Complexity: O(1) because we use no extra memory
     *                        (The nested list does not count because we return it)
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new LinkedList<>();
        // sort the array
        Arrays.sort(nums);
        // Run through all indices of a possible first element of a triplet
        for (int i = 0; i < nums.length - 2; i++) { // nums.length - 2 since we want triplets

            if(nums[i] > 0) return list; // OPTIMISATION CHECK COMMENT BELOW*

            // we want to skip equal elements so that our answer doesn't contain duplicates
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // for each possible first element we make a standard bi-directional
                // 2Sum sweep of the remaining part of the array
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++; // skip duplicates
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--; // gotta skip em all
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return list;
    }

    /*
     *  Since the array is sorted, if the first element of our potential triplet is 0, then
     *  it is impossible to have a triplet that adds up to 0. It is also impossible for any other
     *  element to the right of our current element to be the first member of a triplet.
     *  Because of this we break early to avoid unnecessary computation, thus optimising the
     *  runtime of our algorithm
     */
}
