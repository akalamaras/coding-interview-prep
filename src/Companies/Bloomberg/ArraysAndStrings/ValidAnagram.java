package Companies.Bloomberg.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s == null && t == null)
            return true;

        if(s == null || t == null)
            return false;

        if(s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for(char c : t.toCharArray()) {

            if(!map.containsKey(c))
                return false;
            else {
                if(map.get(c) == 1)
                    map.remove(c);
                else
                    map.put(c, map.get(c) - 1);
            }
        }
        return map.isEmpty();
    }

    public boolean isAnagramUnicode(String s, String t) {

        if(s == null && t == null)
            return true;

        if(s == null || t == null)
            return false;

        if(s.length() != t.length())
            return false;

        int[] container = new int[256];

        for(char c: s.toCharArray())
            container[c]++;

        for(char c : t.toCharArray()) {
            container[c]--;
            if(container[c] < 0)
                return false;
        }
        return true;
    }

    public boolean onePass(String s, String t) {

        if(s == null && t == null)
            return true;

        if(s == null || t == null)
            return false;

        if(s.length() != t.length())
            return false;

        int[] counter = new int[256];
        for(int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
            counter[t.charAt(i)]--;
        }

        for(int count: counter) {
            if(count != 0)
                return false;
        }
        return true;


    }
}
