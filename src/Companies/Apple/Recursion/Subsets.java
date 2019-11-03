package Companies.Apple.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int start,  List<Integer> current, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(current));

        if(current.size() == nums.length)
            return;

        for(int i = start; i < nums.length; i++) {

            int n = nums[i];
            if(!current.contains(n)) {

                current.add(n);
                backtrack(nums, i + 1, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }
}
