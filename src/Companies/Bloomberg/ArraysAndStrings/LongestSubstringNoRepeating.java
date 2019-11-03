package Companies.Bloomberg.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeating {

    public static void main(String[] args) {

        LongestSubstringNoRepeating lsnr = new LongestSubstringNoRepeating();
        System.out.println(lsnr.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0)
            return 0;

        Map<Character,Integer> map = new HashMap<>();

        int j = 0;
        int max = 0;
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
