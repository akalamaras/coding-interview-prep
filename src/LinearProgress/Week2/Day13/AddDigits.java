package LinearProgress.Week2.Day13;

import java.util.*;

public class AddDigits {

    private int addDigits(int num) {
        while(num > 9) num = sumDigits(splitNum(num));
        return num;
    }

    private List<Integer> splitNum(int num) {
        List<Integer> list = new ArrayList<>();
        while(num > 0) {
            list.add(num%10);
            num /= 10;
        }
        return list;
    }

    private int sumDigits(List<Integer> list) {
        int total = 0;
        for(int num: list) total += num;
        return total;
    }

    private int pureMaths(int n) {
        return 1+(n-1)%9;
    }

    public static void main(String[] args) {

        AddDigits add = new AddDigits();
        System.out.println(add.addDigits(38));
    }
}
