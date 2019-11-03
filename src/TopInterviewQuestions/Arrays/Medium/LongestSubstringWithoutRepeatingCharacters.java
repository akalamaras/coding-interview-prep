package TopInterviewQuestions.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongest(String s) {

        if(s == null || s.length() == 0)
            return 0;

        Map<Character,Integer> map = new HashMap<>();

        int max = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++) {

            /*
                J will point to the beginning of our string under consideration
                If we have already encountered the char we are on, j will be updated
                to point to the current after the spot where the char was previously at, if that
                spot is not to the left of J.
             */
            if(map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            // Our map will get updated with the index of the last seen character index
            map.put(s.charAt(i),i);
            // i - j + 1 is the length of our current substring under consideration
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
