package TopInterviewQuestions.Arrays.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeArraySort {

    public static void main(String[] args) {

        int[] array1 = {2, 1, 0, 2, 3, 3, 4, 1};
        int[] array2 = {1, 0, 4, 3};

        RelativeArraySort ra = new RelativeArraySort();
        System.out.println(Arrays.toString(ra.relativeSortArray(array1, array2)));
    }

    public int[] relativeSortArray(int[] array1, int[] array2) {

        int[] count = new int[1001];

        for (int n : array1)
            count[n]++;


        int pointer = 0;
        for (int n : array2) {
            while (count[n]-- > 0)
                array1[pointer++] = n;
        }

        for(int n = 0; n < count.length; n++) {
            while(count[n]-- > 0)
                array1[pointer++] = n;
        }
        return array1;


    }
}
