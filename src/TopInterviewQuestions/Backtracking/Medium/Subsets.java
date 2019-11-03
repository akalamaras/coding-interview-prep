package TopInterviewQuestions.Backtracking.Medium;

import Learn.RecursionII.Backtracking.SudokuSolver;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] array = {1,2,3};
        Subsets ss = new Subsets();
        System.out.println(ss.subsets(array));
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums,int start, List<Integer> current,List<List<Integer>> ans) {

        ans.add(new ArrayList<>(current));
        if(nums.length == current.size())
            return;

        for(int i = start; i < nums.length; i++) {
            if(!current.contains(nums[i])) {
                current.add(nums[i]);
                backtrack(nums, i + 1, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }
}

