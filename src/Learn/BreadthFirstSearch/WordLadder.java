package Learn.BreadthFirstSearch;

import java.util.*;
import Support.Pair;

public class WordLadder {

    // One Directional BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        final int LENGTH = beginWord.length();

        // Pre processing to create our dictionary
        Map<String, ArrayList<String>> dictionary = new HashMap<>();
        for(String w : wordList) {
            for(int i = 0; i < LENGTH; i++) {

                String newWord = w.substring(0, i) + '*' + w.substring(i + 1, LENGTH);
                ArrayList<String> transformations = dictionary.getOrDefault(newWord, new ArrayList<>());

                transformations.add(w);
                dictionary.put(newWord, transformations);
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();

        queue.offer(new Pair(beginWord, 1));
        visited.put(beginWord, true);

        while(!queue.isEmpty()) {

            Pair pair = queue.poll();
            String word = pair.getWord();
            int level = pair.getLevel();

            for(int i = 0; i < LENGTH; i++) {

                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, LENGTH);

                for(String adjacentWord : dictionary.getOrDefault(newWord, new ArrayList<>())) {

                    if(adjacentWord.equals(endWord))
                        return level + 1;

                    if(visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
