package LinearProgress.Week2.Day13;

import java.util.*;

public class CountPrimes {

    private int count(int n) {
        ArrayList<Integer> primeList = new ArrayList<>() ;
        if(n == 0 || n == 1) return 0;
        for(int i = 2; i <= n; i++) {
            if(isPrime(i,primeList)) primeList.add(i);
        }
        return primeList.size();
    }

    private boolean isPrime(int n, ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) return true;
        for(int number : list) {
            if(n%number == 0) return false;
        }
        return true;

    }

    private int faster(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(!notPrime[i]) {
                count++;
                for(int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        CountPrimes c = new CountPrimes();
        System.out.println(c.count(1));
    }
}
