package TopInterviewQuestions.Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {


    public String minimumWindowSubstring(String S, String T) {

        Map<Character, Integer> sCounter = new HashMap<>();
        Map<Character, Integer> tCounter = new HashMap<>();

        for (char t : T.toCharArray())
            tCounter.put(t, tCounter.getOrDefault(t, 0) + 1);

        String min = "";
        int leftP = 0;

        for (int rightP = 0; rightP < S.length(); rightP++) {

            char c = S.charAt(rightP);
            sCounter.put(c, sCounter.getOrDefault(c, 0) + 1);

            while (containsAll(sCounter, tCounter)) {

                min = setMinimumString(min, S.substring(leftP, rightP + 1));

                char toRemove = S.charAt(leftP);
                sCounter.put(toRemove, sCounter.get(toRemove) - 1);

                if(sCounter.get(toRemove) == 0)
                    sCounter.remove(toRemove);

                leftP++;
            }
        }
        return min;
    }

    private boolean containsAll(Map<Character, Integer> sCounter, Map<Character, Integer> tCounter) {

        for (Character key : tCounter.keySet()) {
            if (sCounter.get(key) == null || sCounter.get(key) < tCounter.get(key))
                return false;
        }
        return true;
    }

    private String setMinimumString(String currentMin, String potentialMin) {

        if (currentMin.equals(""))
            return potentialMin;

        return (currentMin.length() < potentialMin.length()) ? currentMin : potentialMin;
    }
}
