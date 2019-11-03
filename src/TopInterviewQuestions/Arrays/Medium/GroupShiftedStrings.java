package TopInterviewQuestions.Arrays.Medium;

import java.util.*;

public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {

        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strings) {

            int offset = s.charAt(0) - 'a';
            String key = "";

            for(int i = 0; i < s.length(); i++) {

                char c = (char) (s.charAt(i) - offset);
                if(c < 'a')
                    c += 26;

                key += c;
            }

            if(!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(s);
        }

        for(String key: map.keySet()) {

            List<String> list = map.get(key);
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }
}
