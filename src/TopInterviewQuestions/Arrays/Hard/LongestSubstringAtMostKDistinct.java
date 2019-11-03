package TopInterviewQuestions.Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostKDistinct {

    public int hashMap(String s, int k) {

        Map<Character, Integer> count = new HashMap<>();

        int max = 0, i = 0;
        for(int j = 0; j < s.length(); j++) {

            char c = s.charAt(j);
            count.put(c, count.getOrDefault(c, 0) + 1);

            if(count.size() > k) {
                char left = s.charAt(i);

                if(count.containsKey(left))
                    count.put(left, count.get(left) - 1);
                if(count.get(left) == 0)
                    count.remove(left);

                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }



    public int noWhileLoop(String s, int k) {

        int[] count = new int[256];
        int uniqueNumber = 0, max = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {

            if(count[s.charAt(j)]++ == 0)
                uniqueNumber++;

            if(uniqueNumber > k) {
                count[s.charAt(i)]--;
                if(count[s.charAt(i)] == 0)
                    uniqueNumber--;
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }


    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int[] count = new int[256];

        int number = 0, max = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {

            if(count[s.charAt(j)]++ == 0)
                number++;

            while(number > k && i < s.length()) {

                count[s.charAt(i)]--;
                if(count[s.charAt(i)] == 0)
                    number--;

                i++;
            }

            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
