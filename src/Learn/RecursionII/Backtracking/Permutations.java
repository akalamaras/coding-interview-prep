package Learn.RecursionII.Backtracking;

import java.util.*;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return ans;

        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int i, List<Integer> current, List<List<Integer>> ans) {

        if(current.size() == nums.length) {
            ans.add(current);
            return;
        }

        for(int n : nums) {
            if(!current.contains(n)) {
                List<Integer> newList = new ArrayList<>(current);
                newList.add(n);
                backtrack(nums, i + 1, newList, ans);
            }
        }
    }
}
