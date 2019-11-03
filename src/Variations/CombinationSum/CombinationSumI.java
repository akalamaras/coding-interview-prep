package Variations.CombinationSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSumI {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        if(candidates == null || candidates.length == 0)
            return ans;

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current,
                           List<List<Integer>> ans) {

        if(target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        } else if(target < 0)
            return;
        else {

            for(int i = start; i < candidates.length; i++) {
                current.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, current, ans);
                current.remove(current.size()-1);
            }
        }
    }
}
