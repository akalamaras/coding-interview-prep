package Learn.RecursionII.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParentheses(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String current, int open, int close, int max) {

        if(current.length() == max * 2) {
            list.add(current);
            return;
        }

        if(open < max)
            backtrack(list, current + "(", open + 1, close, max);

        if(close < open)
            backtrack(list, current + ")", open, close + 1, max);

    }
}
