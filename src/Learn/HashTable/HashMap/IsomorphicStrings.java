package Learn.HashTable.HashMap;

import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        HashMap<Character,Character> replacements = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        if(s.length() != t.length())
            return false;

        for(int i = 0; i < s.length(); i++) {
            if(!replacements.containsKey(s.charAt(i)) && !replacements.containsValue(t.charAt(i)))
                replacements.put(s.charAt(i), t.charAt(i));
        }

        for(int i = 0; i < s.length(); i++)
                sb.append(replacements.get(s.charAt(i)));

        System.out.println(sb.toString());
        return sb.toString().equals(t);
    }

    public static void main(String[] args) {

        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic("ab","aa"));
    }


}
