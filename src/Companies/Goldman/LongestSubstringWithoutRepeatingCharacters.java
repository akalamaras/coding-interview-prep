package Companies.Goldman;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongest(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j =0;
        for(int i = 0; i < s.length(); i++) {

            if(map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i)));
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
