package Variations.Subsets;

import java.util.ArrayList;
import java.util.List;

public class SubsetsI {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return ans;

        ans.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> ans) {

        if(current.size() == nums.length && !ans.contains(current)) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < nums.length; i++) {

            int n = nums[i];
            if(!current.contains(n)) {

                current.add(n);
                ans.add(new ArrayList<>(current));
                backtrack(nums, i + 1,current, ans);
                current.remove(current.size()-1);
            }
        }
    }
}
