package Companies.Apple.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    // Initial draft -> Does not handle duplicates -> Will iterate afterwards to remove unnecessary computation
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();

        int[] copy = nums.clone();
        Arrays.sort(copy);

        for(int i = 0; i < copy.length - 3; i++) {

            for(int j = nums.length - 1; j >= i + 2; j--) {

                int remainder = target - copy[i] - copy[j];

                int left = i + 1, right = j - 1;
                while(left < right) {

                    int sum = copy[left] + copy[right];

                    if(sum == remainder) {
                        list.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        left++;
                        right--;
                    } else if(sum < remainder)
                        left++;
                    else
                        right--;
                }
            }
        }
        return list;
    }

    class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {

            List<List<Integer>> list = new ArrayList<>();

            if(nums == null || nums.length < 4)
                return list;

            int[] copy = nums.clone();
            Arrays.sort(copy);

            for(int i = 0; i < copy.length - 3; i++) {

                if(nums[i] * 4 > target)
                    return list;

                for(int j = copy.length - 1; j > i + 2; j--) {

                    if(nums[j] * 4 < target)
                        break;

                    int remainder = target - copy[i] - copy[j];

                    int left = i + 1, right = j - 1;
                    while(left < right) {

                        int sum = copy[left] + copy[right];

                        if(sum == remainder) {
                            list.add(Arrays.asList(copy[i], copy[left], copy[right], copy[j]));

                            while(left < right && copy[left] == copy[left + 1])
                                left++;

                            while(left < right && copy[right] == copy[right - 1])
                                right--;

                            left++;
                            right--;

                        } else if(sum < remainder)
                            left++;
                        else
                            right--;
                    }
                    while(j >= 1 && nums[j] == nums[j - 1])
                        j--;
                }
                while(i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
            return list;
        }
    }
}
