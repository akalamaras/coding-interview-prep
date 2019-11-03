package TopInterviewQuestions.SortingAndSearching.Medium;

import java.util.*;

public class MinimumGeneticMutation {

    public int backtracking(String start, String end, String[] bank) {

        if(start.isEmpty() || end.isEmpty() || bank.length == 0 || start.length() != end.length())
            return -1;
        if(start.equals(end))
            return 0;

        return helper(start, end, bank, new HashSet<>(), 0);
    }

    private int helper(String current, String end, String[] bank, Set<String> path, int depth) {

        if(current.equals(end))
            return depth;
        if(depth >= end.length())
            return -1;

        int min = -1;
        for(String gene : bank) {

            if(!path.contains(gene) && isClose(current, gene)) {

                path.add(gene);

                int num = helper(gene, end, bank, path, depth + 1);
                if(num != -1)
                    min = num;

                path.remove(gene);
            }
        }
        return min;
    }

    private boolean isClose(String current, String gene) {

        if(current.length() != gene.length())
            return false;

        int diff = 0;
        for(int i = 0; i < current.length(); i++) {
            if(current.charAt(i) != gene.charAt(i) && ++diff > 1)
                return false;
        }
        return true;
    }

    public int minMutation(String start, String end, String[] bank) {

        if (start.equals(end))
            return 0;

        Set<String> set = new HashSet<>();
        Collections.addAll(set, bank);

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                String current = queue.poll();
                if (current.equals(end))
                    return level;

                char[] currentArray = current.toCharArray();
                for (int i = 0; i < currentArray.length; i++) {


                    char old = currentArray[i];

                    for (char c : charSet) {
                        currentArray[i] = c;
                        String next = new String(currentArray);
                        if (!visited.contains(next) && set.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    currentArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
