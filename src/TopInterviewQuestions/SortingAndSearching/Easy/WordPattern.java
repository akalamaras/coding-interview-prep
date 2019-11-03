package TopInterviewQuestions.SortingAndSearching.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {

        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("j",  "jquery"));
    }

    public boolean wordPattern(String pattern, String str) {

        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<>();

        if(arr.length!= pattern.length())
            return false;

        for(int i=0; i<arr.length; i++){

            char c = pattern.charAt(i);
            if(map.containsKey(c)) {

                if(!map.get(c).equals(arr[i]))
                    return false;
            } else {

                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }
}
