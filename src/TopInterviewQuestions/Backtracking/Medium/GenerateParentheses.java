package TopInterviewQuestions.Backtracking.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(), n, n, n * 2, ans);
        return ans;
    }

    private void backtrack(StringBuilder sb, int remLeft, int remRight, int max, List<String> ans) {

        // Base case
        if(sb.length() == max) {
            ans.add(sb.toString());
            return;
        }

        // Branching & Constraints
        if(remLeft <= remRight && remLeft > 0) {
            sb.append('(');
            backtrack(sb, remLeft - 1, remRight, max, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(remLeft <= remRight && remRight > 0) {
            sb.append(')');
            backtrack(sb, remLeft, remRight - 1, max, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
