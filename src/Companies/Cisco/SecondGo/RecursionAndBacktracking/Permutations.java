package Companies.Cisco.SecondGo.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] nums, List<Integer> current, List<List<Integer>> ans) {

        if(current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {

            if(!current.contains(nums[i])) {
                current.add(nums[i]);
                helper(nums, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }
}
