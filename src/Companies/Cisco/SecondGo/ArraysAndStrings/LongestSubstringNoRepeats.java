package Companies.Cisco.SecondGo.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeats {

    public static void main(String[] args) {

        LongestSubstringNoRepeats lsnr = new LongestSubstringNoRepeats();
        System.out.println(lsnr.lengthOfLongest("qwertyuiopp"));
    }

    public int lengthOfLongest(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {

            if(map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i)) + 1);

            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
