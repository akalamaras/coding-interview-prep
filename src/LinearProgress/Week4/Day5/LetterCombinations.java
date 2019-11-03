package LinearProgress.Week4.Day5;

import java.util.*;

public class LetterCombinations {

    Map<String,String> map = new HashMap<>() {
        {
            put("2","abc");
            put("3","def");
            put("4","ghi");
            put("5","jkl");
            put("6","mno");
            put("7","pqrs");
            put("8","tuv");
            put("9","wxyz");
        }
    };
    List<String> output = new ArrayList<>();

    public void recursive(String combination, String next_digits) {
        /* if there are no more digits to check then the combination is done */
        if(next_digits.length() == 0) output.add(combination);
        else {
            String digit = next_digits.substring(0,1);
            String letters = map.get(digit);
            for(int i=0; i< letters.length(); i++) {
                String letter = letters.substring(i,i+1);
                recursive(combination+letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ret = new LinkedList<>();
        if(digits.isEmpty()) return ret;
        String[] mappings = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ret.add("");
        while(ret.peek().length() != digits.length()) {
            String remove = ret.remove();
            String map = mappings[digits.charAt(remove.length()-'0')];
            for(char c: map.toCharArray()) {
                ret.addLast(remove+c);
            }

        }
        return ret;

    }
}
