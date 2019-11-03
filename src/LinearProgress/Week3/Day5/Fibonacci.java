package LinearProgress.Week3.Day5;

import java.util.HashMap;

public class Fibonacci {

    private int naiveFib(int n) {
        if( n< 2) return n;
        else return naiveFib(n-1)+naiveFib(n-2);
    }

    private int betterFib(int n) {

        HashMap<Integer,Integer> map = new HashMap<>();
        if (map.containsKey(n)) return map.get(n);
        int result;
        if(n<2) result = n;
        else result = betterFib(n-1) + betterFib(n-2);
        map.put(n,result);
        return result;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.betterFib(15));
        System.out.println(fib.naiveFib(15));
    }
}
