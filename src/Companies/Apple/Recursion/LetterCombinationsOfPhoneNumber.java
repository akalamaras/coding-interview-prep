package Companies.Apple.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {

        ArrayList<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0)
            return result;

        Map<Character, String> mappings = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        helper(digits, 0, new StringBuilder(), result, mappings);
        return result;
    }

    private void helper(String digits, int index, StringBuilder current, ArrayList<String> result,
                        Map<Character, String> mappings) {

        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mappings.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            current.append(c);
            helper(digits, index + 1, current, result, mappings);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
