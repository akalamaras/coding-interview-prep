package TopInterviewQuestions.Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

        public List<String> findMissingRanges(int[] nums, int lower, int upper) {

            List<String> ans = new ArrayList<>();

            if(nums == null || nums.length == 0) {
                ans.add(formRange(lower,upper));
                return ans;
            }

            // Step 1 : Find the range between lower and the first element in the array
            if(nums[0] > lower)
                ans.add(formRange(lower, nums[0] - 1));

            // Step 2 : Find ranges between adjacent elements in the array
            for(int i = 0; i < nums.length - 1; i++) {

                if(nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1)
                    ans.add(formRange(nums[i] + 1, nums[i + 1] - 1));

            }

            // Step 3 : Find the range between upper and the last element in the array
            if(nums[nums.length - 1] < upper)
                ans.add(formRange(nums[nums.length - 1] + 1, upper));

            return ans;
        }

        private String formRange(int lower, int upper) {
            if(lower == upper)
                return String.valueOf(lower);
            else
                return lower + "->" + upper;
        }
}
