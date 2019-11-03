package TopInterviewQuestions.Arrays.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpDomains) {

        Map<String, Integer> count = new HashMap<>();

        for(String s: cpDomains) {

            String[] firstSplit = s.split(" ");
            String[] secondSplit = firstSplit[1].split("\\.");

            int num = Integer.parseInt(firstSplit[0]);

            String current = "";
            for(int i = secondSplit.length - 1; i >= 0; i--) {

                current = secondSplit[i] + (i < secondSplit.length - 1 ? "." : "") + current;
                count.put(current, count.getOrDefault(current, 0) + num);
            }
        }

        List<String> answer = new ArrayList<>();

        for(String key : count.keySet())
            answer.add(count.get(key) + " " + key);
        return answer;
    }
}
