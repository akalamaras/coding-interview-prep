package LinearProgress.Week3.Day3;

import java.util.*;

public class LongestSubstringNoRepeats {

    private int lengthOfLongestSubString(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {

        LongestSubstringNoRepeats l = new LongestSubstringNoRepeats();
        System.out.println(l.lengthOfLongestSubString(""));
    }
}
