package Companies.Goldman;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String each : strs) {

            char[] temp = each.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);

            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(each);
        }
        return new ArrayList<>(map.values());
    }
}
