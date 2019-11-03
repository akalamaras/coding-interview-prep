package Redos.Medium.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int max = 0, j = 0;
        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(map.containsKey(c))
                j = Math.max(j, map.get(c) + 1);

            map.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
