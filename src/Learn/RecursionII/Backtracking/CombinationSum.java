package Learn.RecursionII.Backtracking;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates == null || candidates.length == 0)
            return list;

        backtrack(candidates, target, new ArrayList<>(), 0, 0, list);
        return list;
    }

    private void backtrack(int[] candidates, int target, List<Integer> current, int currentSum, int start,
                           List<List<Integer>> list) {

        // Base case
        if (currentSum == target) {
            list.add(current);
            return;
        } else if (currentSum > target)
            return;



        // Branching
        for(int i = start; i < candidates.length; i++) {
            int newSum = currentSum + candidates[i];
            List<Integer> newList = new ArrayList<>(current);
            newList.add(candidates[i]);
            backtrack(candidates, target, newList, newSum, i, list);

        }
    }
}
