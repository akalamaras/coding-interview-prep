package Companies.Apple.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return list;

        helper(nums, 0, new ArrayList<>(), list);
        return list;
    }

    private void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> list) {

        if(current.size() == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }

        for(int n : nums) {
            if(!current.contains(n)) {
                current.add(n);
                helper(nums, index + 1, current, list);
                current.remove(current.size() - 1);
            }
        }
    }
}
