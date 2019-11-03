package Companies.Apple.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();

        if(candidates == null || candidates.length == 0)
            return list;

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current,
                           List<List<Integer>> list) {

        if(target == 0) {
            list.add(new ArrayList<>(current));
            return;
        } else if(target < 0)
            return;

        for(int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, list);
            current.add(current.size() - 1);
        }
    }
}
