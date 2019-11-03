package Companies.Goldman;

import java.util.*;

public class FirstUniqueCharacter {

    class HashMapApproach {

        public int firstUnique(String s) {

            HashMap<Character,Integer> times = new HashMap<>();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(times.containsKey(c))
                    times.put(c,times.get(c)+1);
                else
                    times.put(c, 1);

            }
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(times.get(c) == 1)
                    return i;
            }
            throw new IllegalArgumentException("No unique character");
        }
    }
}
