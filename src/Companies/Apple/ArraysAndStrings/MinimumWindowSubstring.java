package Companies.Apple.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if(s == null || s.length() == 0)
            return "";

        if(t == null || t.length() == 0)
            return "";

        Map<Character, Integer> tCounts = new HashMap<>();
        for(char ch : t.toCharArray())
            tCounts.put(ch, tCounts.getOrDefault(ch, 0) + 1);

        int required = tCounts.size();

        int formed = 0;
        int left = 0, right = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        // answer[0] = window length, answer[1] = left, answer[2] = right
        int[] answer = { -1, 0, 0};

        while(right < s.length()) {

            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if(tCounts.containsKey(c) && windowCounts.get(c).intValue() == tCounts.get(c).intValue())
                formed++;

            // Try and contract
            while(left <= right && formed == required) {

                char current = s.charAt(left);
                // Save the smallest window until now
                if(answer[0] == - 1 || right - left + 1 < answer[0]) {
                    answer[0] = right - left + 1;
                    answer[1] = left;
                    answer[2] = right;
                }
                windowCounts.put(current, windowCounts.get(c) - 1);
                if(tCounts.containsKey(current) && windowCounts.get(current).intValue()
                                                    < tCounts.get(current).intValue())
                    formed--;

                left++;
            }
            right--;
        }
        return answer[0] == -1 ? "" : s.substring(answer[1], answer[2] + 1);
    }


    public int maximumWindow(String s) {

        int[] map = new int[128];

        int counter = 0, begin = 0, end = 0, res = 0;
        while(end < s.length()) {

            if(map[s.charAt(end)] > 0)
                counter++;
            map[s.charAt(end)]++;
            end++;
            while(counter > 0) {
                if(map[s.charAt(begin)] > 1)
                    counter--;
                map[s.charAt(begin)]--;
                begin++;
            }
            res = Math.max(res, end - begin);
        }
        return res;
     }
}
