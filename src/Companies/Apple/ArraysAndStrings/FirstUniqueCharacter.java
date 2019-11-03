package Companies.Apple.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int firstUniqueChar(String s) {

        Map<Character, Integer> counter = new HashMap<>();

        for(char c : s.toCharArray())
            counter.put(c, counter.getOrDefault(c, 0) + 1);

        for(int i = 0; i < s.length(); i++)
            if(counter.get(s.charAt(i)) == 1)
                return i;
        return -1;
    }
}
