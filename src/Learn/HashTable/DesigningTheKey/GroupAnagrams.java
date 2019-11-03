package Learn.HashTable.DesigningTheKey;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();

        for(String s: strs) {

            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String keyString = String.valueOf(charArray);

            if(!map.containsKey(keyString))
                map.put(keyString,new ArrayList<>());
            map.get(keyString).add(s);
        }
        return new ArrayList<>(map.values());

    }
}
