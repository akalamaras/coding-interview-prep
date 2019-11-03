package TopInterviewQuestions.Arrays.Easy;


import java.util.HashSet;

public class ContainsDuplicate {

    public boolean contains(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int n: nums) {
            if(!set.add(n))
                return true;
        }
        return false;
    }
}
