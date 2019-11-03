package Companies.Goldman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public static void main(String[] args) {

        FindAndReplacePattern frp = new FindAndReplacePattern();
        System.out.println(frp.makePatternList("xyx"));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> answer = new ArrayList<>();
        List<Integer> patternList = makePatternList(pattern);

        for (String s : words) {
            if (makePatternList(s).equals(patternList))
                answer.add(s);
        }
        return answer;
    }

    private List<Integer> makePatternList(String word) {

        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                list.add(i);
            } else
                list.add(map.get(c));
        }
        return list;
    }
}
