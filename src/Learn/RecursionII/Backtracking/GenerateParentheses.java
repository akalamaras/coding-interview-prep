package Learn.RecursionII.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParentheses(int n) {

        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(), n, n, n * 2, ans);
        return ans;
    }

    private void backtrack(StringBuilder sb, int opening, int closing, int maxLength, List<String> ans) {

        // Base case
        if(sb.length() == maxLength) {
            ans.add(sb.toString());
            return;
        }

        // Branching
        if(opening > 0 && closing >= opening) {
            sb.append('(');
            backtrack(sb, opening - 1, closing, maxLength, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closing > 0 && closing >= opening) {
            sb.append(')');
            backtrack(sb, opening, closing - 1, maxLength, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {

        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParentheses(3));
    }
}
