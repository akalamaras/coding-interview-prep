package TopInterviewQuestions.Backtracking.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {

        LetterCombinationsPhoneNumber lc = new LetterCombinationsPhoneNumber();
        System.out.println(lc.letterCombinations("235"));
    }


    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if(digits == null || digits.length() == 0)
            return ans;

        Map<Integer,String> map = new HashMap<Integer,String>() {{
            put(2,"abc");
            put(3,"def");
            put(4,"ghi");
            put(5,"jkl");
            put(6,"mno");
            put(7,"pqrs");
            put(8,"tuv");
            put(9,"wxyz");
        }};

        backtrack(digits, 0, new StringBuilder(), ans, map);
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> ans,
                           Map<Integer,String> map) {

        // Base case
        if(current.length() == digits.length()) {
            ans.add(current.toString());
            return;
        }

        // Branching
        char[] potential = map.get(Character.getNumericValue(digits.charAt(index))).toCharArray();
        for(char c: potential) {

            current.append(c);
            backtrack(digits, index + 1, current, ans, map);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
