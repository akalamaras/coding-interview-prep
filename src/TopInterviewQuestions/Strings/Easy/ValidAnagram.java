package TopInterviewQuestions.Strings.Easy;

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c: s.toCharArray()) {
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        for(char c: t.toCharArray()) {

            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0)
                    map.remove(c);
            } else
                return false;
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {

        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("anagram","nagaram"));
    }
}
