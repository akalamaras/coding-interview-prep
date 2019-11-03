package LinearProgress.Week3.Day4;

import java.util.*;

public class ThreeSum {

    /**
     * The idea is to sort the input array and then run through the indices of all possible first
     * elements. For each of these, we use a standard TwoSum sweep of the remaining part. We also
     * skip equal elements to avoid duplicates.
     * @param nums an array of integers
     * @return a list of all possible unique triplets that equal 0
     */
    private List<List<Integer>> threeSum(int[] nums) {

        // sort the array
        Arrays.sort(nums);

        List<List<Integer>> ret = new LinkedList<>();
        // iterate through all possible first numbers
        for(int i = 0; i < nums.length - 2; i++) {
            // skip duplicates
            if( (i > 0 && nums[i] != nums[i-1]) || i == 0) {
                // standard bi-directional TwoSum
                int low = i+1, high = nums.length-1, sum = 0 - nums[i];
                while(low < high) {
                    if(nums[low] + nums[high] == sum) {
                        ret.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        // skip the duplicates
                        while( low < high && nums[low] == nums[low+1]) low++;
                        while( low < high && nums[high] == nums[high-1]) high--;

                        low++;
                        high--;
                    } else if(nums[low] + nums[high] < sum) low++;
                    else high--;
                }
            }
        }
        return ret;
    }

    // ! Idea
    // Break after nums[i] > 0. Since the array is sorted,
    // its impossible for the sum to be 0

    public static void main(String[] args) {

        ThreeSum ts = new ThreeSum();
        int[] array = {-1,0,1,2,-1,4};
        System.out.println(ts.threeSum(array));
    }
}
