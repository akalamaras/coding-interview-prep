package TopInterviewQuestions.Backtracking.Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        Permutations p = new Permutations();
        int[] array = new int[] {1,2,3,4};
        System.out.println(p.permute(array));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return ans;

        backtrack(nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> ans) {

        // Base case
        if(current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Branching
        for(int i = 0; i < nums.length; i++) {
            if(!current.contains(nums[i])) {

                current.add(nums[i]);
                backtrack(nums, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }
}
