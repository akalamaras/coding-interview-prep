package TopInterviewQuestions.Backtracking.Hard;

import java.util.*;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        char[] check = new char[] {'(', ')'};

        backtrack(s, check, 0, 0, result);
        return result;
    }

    private void backtrack(String s, char[] check, int lastI, int lastJ, List<String> result) {

        // positive count == more '(' , negative count == more ')'
        int count = 0;
        int i = lastI;

        while(i < s.length() && count >= 0) {

            if(s.charAt(i) == check[0]) count++;
            else if(s.charAt(i) == check[1]) count--;
            i++;
        }

        // Detected extra '('
        if(count >= 0) {

            String reversed = new StringBuffer(s).reverse().toString();

            /*
             If the string wasn't reversed to begin with (that is to say,
              I haven't changed the order in my check array), then I change it and look for invalid ')'
             However, if I had reversed it (so i found no extra ')'), and then didnt find any again, that means
             my expression is valid.
             */
            if(check[0] == '(')
                backtrack(reversed, new char[] {')','('}, 0, 0, result);
            else
                result.add(reversed);
        }
        // Detected extra ')'
        else {

            i--;
            for(int j = lastJ; j <= i; j++) {

                // Remove the character at j and recurse on the remaining string
                if(s.charAt(j) == check[1] && (j == lastJ || s.charAt(j - 1) != check[1]))
                    backtrack(s.substring(0, j) + s.substring(j + 1), check, i, j, result);
            }
        }
    }
}

class Solution2 {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        if(s == null)
            return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(s);
        queue.add(s);

        while(!queue.isEmpty()) {

            String current = queue.poll();

            if(isValid(current))
                result.add(current);
            else {
                for(int i = 0; i < s.length(); i++) {

                    if(s.charAt(i) == '(' || s.charAt(i) == ')') {

                        String t = s.substring(0, i) + s.substring(i + 1);
                        if(!visited.contains(t)) {
                            visited.add(t);
                            queue.add(t);
                        }
                    }
                }

            }
        }
        return result;
    }

    private boolean isValid(String s) {

        int count = 0;
        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if(c == '(')
                count++;
            else if(c == ')' && count-- == 0)
                return false;
        }
        return count == 0;
    }
}
