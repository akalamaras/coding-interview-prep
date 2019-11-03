package Learn.Recursion;

import java.util.HashMap;

public class Fibonacci {

    private int fib(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if (map.containsKey(n)) return map.get(n);
        int result;
        if(n<2) result = n;
        else result = fib(n-1) + fib(n-2);
        map.put(n,result);
        return result;
    }
}
