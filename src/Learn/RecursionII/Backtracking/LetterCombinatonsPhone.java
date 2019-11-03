package Learn.RecursionII.Backtracking;

import java.util.*;

public class LetterCombinatonsPhone {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if(digits == null || digits.length() == 0)
            return ans;


        Map<Integer,String> map = new HashMap<>() {{
            put(2,"abc");
            put(3,"def");
            put(4,"ghi");
            put(5,"jkl");
            put(6,"mno");
            put(7,"pqrs");
            put(8,"tuv");
            put(9,"wxyz");
        }};


        backtrack(digits , 0, "", ans, map);
        return ans;
    }

    private void backtrack(String digits, int i, String sb,List<String> ans, Map<Integer,String> map) {

        // Base case
        if(i == digits.length()) {
            ans.add(sb);
            return;
        }

        // Branching

        if(digits.charAt(i) == '1')
            backtrack(digits, i + 1, sb, ans, map);
        else {
            int number = Character.getNumericValue(digits.charAt(i));
            String potentialLetters = map.get(number);
            for (char c : potentialLetters.toCharArray()) {
                backtrack(digits, i + 1, sb + c, ans, map);
            }
        }
    }
}
