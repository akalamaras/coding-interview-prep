package Learn.HashTable.HashMap;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {

    public int firstUnique(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;

    }

    public static void main(String[] args) {

        FirstUniqueCharacterInAString fucias = new FirstUniqueCharacterInAString();
        System.out.println(fucias.firstUnique("loveleetcode"));
    }
}
