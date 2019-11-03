package TopInterviewQuestions.Arrays.Medium;

import java.util.*;

public class RandomFlipMatrix {

    class Solution2 {

        Map<Integer, Integer> map;
        int m, n, total;
        Random rand;

        public Solution2(int n_rows, int n_cols) {

            map = new HashMap<>();
            rand = new Random();
            m = n_rows;
            n = n_cols;
            reset();
        }

        public int[] flip() {

            int i = rand.nextInt(total--);
            int x = map.getOrDefault(i, i);
            map.put(i, map.getOrDefault(total, total));
            map.put(total, x);
            return new int[] {x / n, x % n};
        }

        public void reset() {
            total = m * n;
        }
    }

    class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    class Solution {

        private int[][] matrix;
        private List<Pair> list;

        public Solution(int n_rows, int n_cols) {

            matrix = new int[n_rows][n_cols];
            list = new ArrayList<>();
        }

        // Chooses a 0 value in the matrix at random, changes it to 1, then returns
        // the position of the value
        public int[] flip() {

            Pair pair;
            do {
                int randomX = (int) (Math.random() * matrix.length);
                int randomY = (int) (Math.random() * matrix[0].length);
                pair = new Pair(randomX, randomY);

            } while(contains(list, pair));

            matrix[pair.getX()][pair.getY()] = 1;
            list.add(pair);

            return new int[] {pair.getX(), pair.getY()};

        }

        // Resets the matrix to 0
        public void reset() {

            for(Pair p : list)
                matrix[p.getX()][p.getY()] = 0;
            list.clear();


        }

        private boolean contains(List<Pair> list, Pair pair) {

            for(Pair p : list) {
                if(p.getX() == pair.getX() && p.getY() == pair.getY())
                    return true;
            }
            return false;
        }

    }
}
