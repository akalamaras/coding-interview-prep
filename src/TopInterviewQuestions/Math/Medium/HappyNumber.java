package TopInterviewQuestions.Math.Medium;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {

        Set<Integer> inLoop = new HashSet<>();

        while(!inLoop.contains(n)) {

            inLoop.add(n);
            n = digitSquareSum(n);
            if(n == 1)
                return true;
        }
        return false;
    }

    private int digitSquareSum(int n) {

        int sum = 0;
        while(n > 0) {
            int temp = n%10;
            sum += temp * temp;
            n = n/10;
        }
        return sum;
    }
}
