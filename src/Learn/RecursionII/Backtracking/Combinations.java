package Learn.RecursionII.Backtracking;

import java.util.*;

public class Combinations {

    private List<List<Integer>> output;
    private int n;
    private int k;

    public Combinations() {
        output = new ArrayList<>();
    }

    public List<List<Integer>> combine(int n, int k) {

        this.n = n;
        this.k = k;

        backtrack(1, new LinkedList<>());
        return output;
    }

    private void backtrack(int first, LinkedList<Integer> current) {

        if(current.size() == k)
            output.add(new LinkedList<>(current));

        for(int i = first; i <= n; i++) {

            current.add(i);
            backtrack(i + 1, current);
            current.removeLast();
        }
    }
}
