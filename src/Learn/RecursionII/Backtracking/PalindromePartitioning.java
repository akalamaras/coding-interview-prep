package Learn.RecursionII.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    class Solution {


        public List<List<String>> partition(String s) {

            List<List<String>> ans = new ArrayList<>();
            List<String> current = new ArrayList<>();
            backtrack(s, 0, current, ans);
            return ans;
        }

        private void backtrack(String s, int pos, List<String> current, List<List<String>> ans) {

            // Base case
            if( pos == s.length()) {
                ans.add(new ArrayList<>(current));
                return;
            }

            for(int i = pos; i < s.length(); i++) {

                if(validPalindrome(s, pos, i)) {

                    current.add(s.substring(pos, i + 1));
                    backtrack(s, i + 1, current, ans);
                    current.remove(current.size() - 1);
                }
            }
        }

        private boolean validPalindrome(String s, int low, int high) {

            while(low < high)
                if(s.charAt(low++) != s.charAt(high--))
                    return false;
            return true;
        }
    }








































    public static void main(String[] args) {

        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("aab"));
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        if(s == null || s.length() == 0)
            return ans;

        backtrack(s.toCharArray(), new ArrayList<>(), ans, 0);
        return ans;
    }

    private void backtrack(char[] array, List<String> current, List<List<String>> ans, int start) {

        if(current.size() > array.length)
            return;

        if(isValidPalindrome(current))
            ans.add(new ArrayList<>(current));

        for(int i = start; i < array.length; i++) {

            current.add(String.valueOf(array[i]));
            println(current);
            backtrack(array,current, ans, i + 1);
            current.remove(current.size() - 1);
        }
    }

    private boolean isValidPalindrome(List<String> current) {

        if(current.size() == 1)
            return true;

        StringBuilder sb = new StringBuilder();
        for(String s : current)
            sb.append(current);
        String temp = sb.toString();

        int head = 0, tail = temp.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = temp.charAt(head);
            cTail = temp.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    private void println(List<String> list) {

        for(String n: list)
            System.out.print(n + " ");
        System.out.println();
    }
}
