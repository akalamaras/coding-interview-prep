package TopInterviewQuestions.Arrays.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstringUniqueT {

    public static void main(String[] args) {

        MinimumWindowSubstringUniqueT mws = new MinimumWindowSubstringUniqueT();
        System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> charCounter = new HashMap<>();

        Set<Character> tSet = new HashSet<>();
        for(char ch : t.toCharArray())
            tSet.add(ch);

        int leftP = 0;
        String min = "";

        // Widening the sliding window
        for(int rightP = 0; rightP < s.length(); rightP++) {

            char ch = s.charAt(rightP);
            charCounter.put(ch, charCounter.getOrDefault(ch, 0) + 1);

            // Shortening the sliding window
            while(containsAll(charCounter, tSet)) {

                // Checking for minimum
                min = setMinimumString(min, s.substring(leftP, rightP + 1));

                char toRemove = s.charAt(leftP);
                charCounter.put(toRemove, charCounter.get(toRemove) - 1);

                if(charCounter.get(toRemove) == 0)
                    charCounter.remove(toRemove);

                leftP++;
            }
        }
        return min;
    }

    private boolean containsAll(Map<Character, Integer> charCounter, Set<Character> tSet) {

        for(char ch : tSet) {
            if(!charCounter.containsKey(ch))
                return false;
        }
        return true;
    }

    private String setMinimumString(String currentMin, String potentialMin) {

        if(currentMin.equals(""))
            return potentialMin;

        return (currentMin.length() < potentialMin.length()) ? currentMin : potentialMin;

    }
}
