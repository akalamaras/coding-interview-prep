package TopInterviewQuestions.Arrays.Easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public int numJewels(String J, String S) {

        Set<Character> set = new HashSet<>();
        for(char c : J.toCharArray())
            set.add(c);

        int count = 0;
        for(char c : S.toCharArray()) {
            if(set.contains(c))
                count++;
        }
        return count;
    }
}
