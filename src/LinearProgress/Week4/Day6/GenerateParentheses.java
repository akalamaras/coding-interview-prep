package LinearProgress.Week4.Day6;

import java.util.*;

public class GenerateParentheses {

    public List<String> generate(int n) {
        List<String> ret = new ArrayList<>();
        backtrack(ret,"",0,0,n);
        return ret;
    }

    public void backtrack(List<String> ans, String current, int open, int close, int max) {
        if(current.length() == max*2) {
            ans.add(current);
            return;
        }
        if(open < max) {
            backtrack(ans,current+"(",open+1,close,max);
        }
        if(close < max) {
            backtrack(ans,current+")",open,close+1,max);

        }
    }
}
