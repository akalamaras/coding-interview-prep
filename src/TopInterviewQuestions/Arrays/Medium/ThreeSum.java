package TopInterviewQuestions.Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] array = {-2,-2,0,1,1,2};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(array));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return ans;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {

            if(i == 0 || nums[i] != nums[i-1]) {

                int sum = 0 - nums[i];

                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {


                    if (nums[left] + nums[right] == sum) {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1])
                            left++;

                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;

                    } else if (nums[left] + nums[right] < sum)
                        left++;
                    else
                        right--;
                }
            }
        }
        return ans;
    }
}
