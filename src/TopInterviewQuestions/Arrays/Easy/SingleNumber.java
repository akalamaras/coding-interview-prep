package TopInterviewQuestions.Arrays.Easy;

import java.util.HashSet;

public class SingleNumber {

    public int singleNumber(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int n: nums) {
            if(set.contains(n))
                set.remove(n);
            else
                set.add(n);
        }
        Object[] array = set.toArray();
        return (int) array[0];
    }
}
