package TopInterviewQuestions.Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                count.put(sum, count.getOrDefault(sum, 0) + 1);
            }
        }

        int result = 0;
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if(count.containsKey(-sum))
                    result += count.get(-sum);

            }
        }
        return result;
    }
}
