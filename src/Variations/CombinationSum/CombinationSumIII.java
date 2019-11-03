package Variations.CombinationSum;

import java.util.*;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        if(k == 0 || n == 0)
            return ans;

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        backtrack(nums, k, n, 0, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int k, int n, int start, List<List<Integer>> ans, List<Integer> current) {

        if(n == 0 && current.size() == k) {
            ans.add(new ArrayList<>(current));
            return;
        } else if(current.size() >= k || n < 0)
            return;
        else {

            for(int i = start; i < nums.length; i++) {


                current.add(nums[i]);
                backtrack(nums, k, n - nums[i], i + 1, ans, current);
                current.remove(current.size()-1);
            }
        }
    }
}
