package Learn.RecursionII.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithUniqueDigits {

    // Wrong

    public int countNumbersWithUniqueDigits(int n) {

        if(n == 0)
            return n;

        int count = 0;
        count += backtrack(n, new ArrayList<>(), 0, count);
        return count;
    }

    private int backtrack(int maxLength, List<Integer> temp, int tempNum, int count) {

        if(tempNum < Math.pow(10,maxLength))
            count++;
        else
            return count;

        for(int i = 0; i < 10; i++) {

            if(!temp.contains(i)) {

                tempNum = tempNum * 10 + i;
                temp.add(i);
                backtrack(maxLength, temp, tempNum, count);
                temp.remove(temp.size()-1);
                tempNum = (tempNum - i)/10;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        NumbersWithUniqueDigits nd = new NumbersWithUniqueDigits();
        System.out.println(nd.countNumbersWithUniqueDigits(2));
    }
}
