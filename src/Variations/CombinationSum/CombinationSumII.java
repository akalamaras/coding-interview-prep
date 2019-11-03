package Variations.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Combination Sum + No Duplicates

public class CombinationSumII {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        if (candidates == null || candidates.length == 0)
            return ans;

        Arrays.sort(candidates);
        backtrack(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> current,
                           int start) {

        if (target == 0)
            ans.add(new ArrayList<>(current));
        else if (target < 0)
            return;
        else {

            for(int i = start; i < candidates.length; i++) {

                // Skip duplicates
                if(i > start && candidates[i] == candidates[i-1])
                    continue;

                current.add(candidates[i]);
                backtrack(candidates, target - candidates[i], ans, current, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
