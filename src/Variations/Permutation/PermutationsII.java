package Variations.Permutation;

import java.util.*;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return ans;

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), ans, visited);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> ans, boolean[] visited) {

        // Base case
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {

            if(!visited[i]) {

                // Constraints
                if(i > 0 && nums[i] == nums[i-1] && visited[i-1])
                    return;

                // Backtracking
                visited[i] = true;
                current.add(nums[i]);
                backtrack(nums, current, ans, visited);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }
}