package TopInterviewQuestions.Design.Medium;

import java.util.Arrays;

public class Flatten2DVector {

    public static void main(String[] args) {

        int[][] array = {
                         {1, 2, 3},
                         {4, 5, 6},
                         {7, 8, 9}
                        };
        Flatten2DVector fv = new Flatten2DVector();
        Vector2D v = fv.new Vector2D(array);

    }



    class Vector2D {

        private int[] vector;
        private int index;

        public Vector2D(int[][] v) {

            this.vector = new int[v.length * v[0].length];
            int i = 0, j = 0;
            for(int k = 0; k < vector.length; k++) {
                vector[k] = v[i][j];
                if(j == v[i].length - 1) {
                    j = 0;
                    i++;
                } else
                    j++;

            }
            System.out.println(Arrays.toString(vector));
            this.index = 0;
        }

        public int next() {
            int temp = vector[index];
            index = index + 1;
            return temp;
        }

        public boolean hasNext() {
            return index < vector.length;
        }
    }

    class Vector2D2 {

        int[][] v;
        int i = 0, j = 0;

        public Vector2D2(int[][] v) {
            this.v = v;
        }

        public int next() {
            return v[i][j++];
        }

        public boolean hasNext() {
            // Move to next available vector
            while(i < v.length && j == v[i].length) {
                i++;
                j = 0;
            }
            return i < v.length;
        }
    }
}
