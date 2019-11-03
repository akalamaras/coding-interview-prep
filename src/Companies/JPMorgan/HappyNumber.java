package Companies.JPMorgan;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy2(int n) {

        if(n == 1)
            return true;

        Set<Integer> inLoop = new HashSet<>();

        n = digitSquareSum(n);
        while(!inLoop.contains(n)) {
            if(n == 1)
                return true;

            inLoop.add(n);
            n = digitSquareSum(n);
        }
        return false;
    }

    public boolean isHappy(int n) {
        if(n < 0)
            return false;
        while (n >= 10)
            n = digitSquareSum(n);
        return (n == 1 || n == 7);
    }

    public int digitSquareSum(int n) {

        int sum = 0, temp;
        while(n != 0) {
            temp = n % 10;
            sum += temp*temp;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {


        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(64));


    }
}
