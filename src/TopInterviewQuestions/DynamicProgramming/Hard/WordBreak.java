package TopInterviewQuestions.DynamicProgramming.Hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    class Backtracking {

        public boolean wordBreak(String str, List<String> dictionary) {
            return helper(str, new HashSet<>(dictionary), 0);
        }

        private boolean helper(String str, Set<String> dictionary, int start) {

            // Base case
            if (start == str.length())
                return true;

            for (int end = start + 1; end <= str.length(); end++) {

                if (dictionary.contains(str.substring(start, end)) && helper(str, dictionary, end))
                    return true;
            }
            return false;
        }
    }

    class BacktrackingWithMemoization {


        public boolean wordBreak(String str, List<String> dictionary) {
            return helper(str, new HashSet<>(dictionary), 0, new Boolean[str.length()]);
        }

        private boolean helper(String str, Set<String> dictionary, int start, Boolean[] memo) {

            if(start == str.length())
                return true;

            if(memo[start] != null)
                return memo[start];

            for(int end  = start + 1; end <= str.length(); end++) {

                if(dictionary.contains(str.substring(start, end)) && helper(str, dictionary, end, memo))
                    return memo[start] = true;
            }
            return memo[start] = false;
        }
    }
}
