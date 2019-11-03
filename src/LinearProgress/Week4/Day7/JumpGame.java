package LinearProgress.Week4.Day7;

public class JumpGame {


    /**
     *
     * Given an array of non-negative integers,
     * you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Determine if you are able to reach the last index.
     *
     * E.g : Input: 2 3 1 1 4
     *       Output: True
     *       Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */

    /* This is a dynamic programming question. Usually, solving a dynamic programming question involves
           a 4 step process.
            1. Start with the recursive backtracking solution.
            2. Optimize by using a memoization table (top-down dynamic programming)
            3. Remove the need for recursion (bottom-up dynamic programming)
            4. Apply final tricks to reduce time/memory complexity

           For this problem, we call a position in the array
            a "good index" if starting at the position we can reach the end of the array,
            a "bad index" otherwise
           The problem reduces to whether index 0 is a "good index"

    */

    // Approach 1: Backtracking/Learn.Recursion TODO
    public boolean canJumpFromPosition(int position, int[] nums) {
        return false;
    }
}
