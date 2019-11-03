package Companies.Apple.DynamicProgramming;

public class RegularExpressionMatching {

    private enum Result {
        TRUE,
        FALSE
    }

    class DynamicProgramming {

        Result[][] table;

        public boolean isMatch(String text, String pattern) {

            table = new Result[text.length() + 1][pattern.length() + 1];
            return dp(0, 0, text, pattern);
        }

        private boolean dp(int i, int j, String text, String pattern) {

            if (table[i][j] != null)
                return table[i][j] == Result.TRUE;

            boolean ans;
            if (j == pattern.length())
                ans = (i == text.length());
            else {

                boolean firstMatch = (i < text.length() &&
                        text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');

                if (j + 1 < pattern.length() && pattern.charAt(j) == '*')
                    ans = (dp(i, j + 2, text, pattern) || firstMatch) && dp(i + 1, j, text, pattern);
                else
                    ans = firstMatch && dp(i + 1, j + 1, text, pattern);
            }

            table[i][j] = ans ? Result.TRUE : Result.FALSE;
            return ans;
        }
    }

    class Solution {
        // Recursive
        public boolean isMatch(String text, String pattern) {

            if (pattern.isEmpty())
                return text.isEmpty();

            boolean firstMatch = (!text.isEmpty() &&
                    (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

            if (pattern.length() > 2 && pattern.charAt(1) == '*')
                return (isMatch(text, pattern.substring(2)) || (isMatch(text.substring(1), pattern) && firstMatch));
            else
                return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
