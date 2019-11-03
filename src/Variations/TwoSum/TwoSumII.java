package Variations.TwoSum;

import java.util.HashMap;

public class TwoSumII {


    /** Input array is sorted
     *
     * We can use the previous solution, but it does not take
     * advantage of the fact that the array is now sorted.
     * We can do better. (check solution #2)
     *
     * O(n) time and O(n) space  */
    public int[] twoSumII(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[] {map.get(complement),i};
            // check if current number is bigger than the target
            if(nums[i] > target)
                throw new IllegalArgumentException("No correct answer");
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No correct answer");
    }

    /** Solution #2. Two Pointers
     *
     * Might want to consider any potential overflow errors
     * and store sum into a long, then compare
     * (check solution #3)
     *
     *  O(n) time and O(1) space  */
    public int[] twoSum2(int[] nums,int target) {

        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            if(nums[left] + nums[right] == target)
                return new int[] {left,right};
            else if(nums[left] + nums[right] < target)
                left++;
            else
                right--;
        }
        throw new IllegalArgumentException("No correct answer");
    }

    /** Solution #3
     *
     * Accounts for any potential overflow errors
     *
     * O(n) time and O(1) space  */
    public int[] twoSum3(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            long sum = nums[left] + nums[right];
            if(sum == target)
                return new int[] {left,right};
            else if(sum < target)
                left++;
            else
                right--;
        }
        throw new IllegalArgumentException("No correct answer");
    }
}
