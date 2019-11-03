package LinearProgress.Week1.Day2;

import java.util.*;

public class LongestCommonPrefix {

    private String bruteForce(String[] strs) {
        try {
            String speciment = strs[0];
            List<Character> characters = new ArrayList<>();
            for (int i = 0; i < speciment.length(); i++) {
                char letter = speciment.charAt(i);
                try {
                    for (int j = 1; j < strs.length; j++) {
                        if (strs[j].charAt(i) != letter)
                            return listToString(characters);
                    }
                    characters.add(letter);
                } catch(StringIndexOutOfBoundsException e) {
                    return listToString(characters);
                }
            }
            return listToString(characters);
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }

    private String listToString(List<Character> list) {

        StringBuilder sb = new StringBuilder();
        for(Character ch: list) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        LongestCommonPrefix longest = new LongestCommonPrefix();
        String[] array = {"aa","a"};
        System.out.println(longest.bruteForce(array));
    }
}
