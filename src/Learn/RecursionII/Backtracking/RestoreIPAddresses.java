package Learn.RecursionII.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public static void main(String[] args) {

        RestoreIPAddresses ra = new RestoreIPAddresses();
        System.out.println(ra.restoreIpAddresses("010010"));

    }

    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        if(s == null || s.length() == 0)
            return ans;

        int[] path = new int[4];
        backtrack(s, 0, path, 0, ans);
        return ans;
    }

    private void backtrack(String s, int buildIndex, int[] path, int segment, List<String> ans) {

        // Base cases

        if(segment == 4 && buildIndex < s.length())
            return;

        if(segment == 4 && buildIndex == s.length()) {
            ans.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
            return;
        }

        if(segment == 4 || buildIndex == s.length())
            return;



        // Branching
        for(int len = 1; len <= 3 && buildIndex + len <= s.length(); len++) {

            int value = Integer.parseInt(s.substring(buildIndex, buildIndex + len));

            // Constraints
            if(value > 255)
                break;

            if(len >= 2 && s.charAt(buildIndex) == 0)
                break;

            path[segment] = value;
            backtrack(s, buildIndex + len, path, segment + 1, ans);
            path[segment] = -1;
        }
    }
}
