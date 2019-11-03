package Variations.CombinationSum;

import java.util.*;

public class CombinationSumIV {

    public int combinationSum(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return 0;


        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, target, new ArrayList<>(), ans);
        return ans.size();
    }

    private void backtrack(int[] nums, int target, List<Integer> current, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        } else if (target < 0)
            return;
        else {

            for (int i = 0; i < nums.length; i++) {

                current.add(nums[i]);
                backtrack(nums, target - nums[i], current, ans);
                current.remove(current.size() - 1);
            }
        }
    }
}
