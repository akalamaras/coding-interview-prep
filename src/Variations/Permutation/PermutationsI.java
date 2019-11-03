package Variations.Permutation;

import java.util.*;

public class PermutationsI {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return ans;

        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;

    }

    private void backtrack(int[] nums, int length, List<Integer> current, List<List<Integer>> ans) {

        // Base case
        if(length == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int n : nums) {

            if(!current.contains(n)) {
                current.add(n);
                backtrack(nums, length + 1, current, ans);
                current.remove(current.size()-1);
            }
        }
    }
}
