package Companies.Apple.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInteger(String s) {

        if(s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int result = map.get(s.charAt(s.length() - 1));
        for(int i = s.length() - 2; i >= 0; i--) {

            if(map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
    }
}
