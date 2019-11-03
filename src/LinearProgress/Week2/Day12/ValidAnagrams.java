package LinearProgress.Week2.Day12;

import java.util.*;

public class ValidAnagrams {

    /*
    private boolean isValid(String s, String t) {
        HashMap<Integer,Character> map1 = createHashMap(s);

        HashMap<Integer,Character> map2 = createHashMap(t);
        if(map1.size() != map2.size()) return false;
        for(int i=0;i<map1.size();i++) {
            char c = map1.get(i);
            if(map2.containsValue(c)) {
                System.out.println(map2.remove(c));
                if(map2.remove(c) == null ) return false;
            }
            else return false;
        }
        return true;
    }
    */

    /*
    private boolean isValid(String s,String t) {
        HashMap<Integer,Character> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++) map1.put(i,s.charAt(i));
        for(int j=0;j<t.length();j++) map2.put(t.charAt(j),j);
        for(int k=0;k<map1.size();k++) {
            char c = map1.get(k);
            if(map2.containsKey(c)) map2.remove(c,map2.get(c));
            else return false;
        }
        return true;
    }
    private HashMap<Integer,Character> createHashMap(String s) {
        HashMap<Integer,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(i,s.charAt(i));
        }
        return map;
    }
    */

    private boolean iGiveUp(String s,String t) {
        if(s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }

    public static void main(String[] args) {
        String s1 = "anagram", s2 = "nagrama";
        ValidAnagrams v = new ValidAnagrams();
        System.out.println(v.iGiveUp(s1,s2));
    }
}
