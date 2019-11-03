package Learn.HashTable.HashSet;

import java.util.HashSet;

public class HappyNumber {

    /**
     *  use the hash set to record the digit sum
     *  once the current sum cannot be added to the set
     *  it means i'm in a loop so i return false
     *  once sum reaches 1 i return true
     */
    public boolean isHappy(int n) {

        HashSet<Integer> inLoop = new HashSet<>();
        int squareSum,remain;

        while(inLoop.add(n)) {
            squareSum = 0;
            while(n > 0) {

                remain = n%10;
                squareSum += remain*remain;
                n = n/10;
            }
            if(squareSum == 1)
                return true;
            else
                n = squareSum;
        }
        return false;




    }
}
