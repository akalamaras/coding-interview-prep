package Companies.Apple.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    public List<String> generate(int n) {

        List<String> ans = new ArrayList<>();
        helper(n, n, n * 2, new StringBuilder(), ans);
        return ans;
    }

    private void helper(int remLeft, int remRight, int max, StringBuilder current, List<String> ans) {

        // Base case
        if(current.length() == max) {
            ans.add(current.toString());
            return;
        }

        // Branching
        if(remLeft <= remRight && remLeft > 0) {
            current.append('(');
            helper(remLeft - 1, remRight, max, current, ans);
            current.deleteCharAt(current.length() - 1);
        }
        if(remLeft <= remRight && remRight > 0) {
            current.append(')');
            helper(remLeft, remRight - 1, max, current, ans);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
