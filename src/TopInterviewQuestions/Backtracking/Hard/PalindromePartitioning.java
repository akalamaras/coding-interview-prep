package TopInterviewQuestions.Backtracking.Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String str) {

        List<List<String>> ans = new ArrayList<>();
        backtrack(str, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String str, int index, List<String> current, List<List<String>> ans) {

        if(index == str.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < str.length(); i++) {

            if(isPalindrome(str, index, i)) {

                current.add(str.substring(index, i + 1));
                backtrack(str, i + 1, current, ans);
                current.remove(current.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String str, int left, int right) {

        while(left < right) {
            if(str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }
}
