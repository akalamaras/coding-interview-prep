package Redos.Medium.ArraysAndStrings;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams ga = new GroupAnagrams();
        System.out.println(ga.groupAnagrams(array));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {

            char[] characters = strs[i].toCharArray();
            Arrays.sort(characters);
            String temp = String.valueOf(characters);

            if(!map.containsKey(temp))
                map.put(temp, new ArrayList<>());
            map.get(temp).add(strs[i]);

        }
        return new ArrayList<>(map.values());
    }
}
