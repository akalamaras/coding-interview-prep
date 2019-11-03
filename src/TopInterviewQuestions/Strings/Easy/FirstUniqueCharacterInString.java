package TopInterviewQuestions.Strings.Easy;

import java.util.HashMap;

public class FirstUniqueCharacterInString {

    public int firstUnique(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if(map.containsKey(current))
                map.put(current,map.get(current)+1);
            else
                map.put(current,1);
        }

        for(int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);
            if(map.get(current) == 1)
                return i;
        }
        return -1;
    }
}
