package TopInterviewQuestions.SortingAndSearching.Hard;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        if(!wordList.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // The null represents the levels in the queue, if we find null, we increment our level
        queue.add(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while(!queue.isEmpty()) {

            String current = queue.poll();


            if(current != null) {

                // Modify each letter individually
                for(int i = 0; i < current.length(); i++) {

                    char[] characters = current.toCharArray();

                    for(char ch = 'a'; ch <= 'z'; ch++) {

                        characters[i] = ch;

                        String word = new String(characters);

                        // Check if we found the end word
                        if(word.equals(endWord))
                            return level + 1;

                        // Put the word in the queue
                        if(wordList.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } else {
                level++;

                if(!queue.isEmpty())
                    queue.add(null);
            }
        }
        return 0;
    }
}
