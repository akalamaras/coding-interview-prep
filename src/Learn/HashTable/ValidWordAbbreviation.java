package Learn.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbreviation {

    Map<String, Set<String>> map;

    public ValidWordAbbreviation(String[] dictionary) {

        map = new HashMap<>();

        for(int i = 0; i < dictionary.length; i++) {

            String a = makeAbbreviation(dictionary[i]);
            Set<String> set = map.containsKey(a) ? map.get(a) : new HashSet<>();
            set.add(dictionary[i]);
            map.put(a, set);
        }
    }

    public boolean isUnique(String word) {

        String a = makeAbbreviation(word);
        return !map.containsKey(a) || map.get(a).contains(word) && map.get(a).size() == 1;
    }

    private String makeAbbreviation(String s) {

        if(s.length() < 3)
            return s;

        return s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1);
    }
}
