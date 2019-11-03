package Companies.Bloomberg.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int firstUniqueBest(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {

            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if(map.get(c) == 1)
                return i;
        }
        return -1;
    }

    public int firstUnique(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + s.length());
            else
                map.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) < s.length())
                return i;
        }
        return -1;
    }
}
