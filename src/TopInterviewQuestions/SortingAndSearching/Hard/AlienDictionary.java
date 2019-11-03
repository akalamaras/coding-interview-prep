package TopInterviewQuestions.SortingAndSearching.Hard;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degrees = new HashMap<>();


        if(words == null || words.length == 0)
            return "";

        for(String word : words) {
            for(char character : word.toCharArray())
                degrees.put(character, 0);
        }

        for(int i = 0; i < words.length - 1; i++) {

            String current = words[i];
            String next = words[i + 1];

            int length = Math.min(current.length(), next.length());

            for(int j = 0; j < length; j++) {

                char c1 = current.charAt(j);
                char c2 = next.charAt(j);

                if(c1 != c2) {

                    Set<Character> set = new HashSet<>();

                    if(map.containsKey(c1))
                        set = map.get(c1);

                    if(!set.contains(c2)) {
                        // Update the set and up the degree
                        set.add(c2);
                        map.put(c1, set);
                        degrees.put(c2, degrees.get(c2) + 1);
                    }
                    // If we find different chars, we aren't interested in the remaining substring
                    break;
                }
            }
        }
        return createString(degrees, map);
    }

    private String createString(Map<Character, Integer> degrees, Map<Character, Set<Character>> map) {

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(char c : degrees.keySet()) {
            if(degrees.get(c) == 0)
                queue.add(c);
        }

        while(!queue.isEmpty()) {

            char c = queue.poll();
            sb.append(c);

            if(map.containsKey(c)) {

                for(char c2 : map.get(c)) {

                    degrees.put(c2, degrees.get(c2) - 1);
                    if(degrees.get(c2) == 0)
                        queue.add(c2);
                }
            }
        }

        if(sb.length() != degrees.size())
            return "";

        return sb.toString();
    }
}
