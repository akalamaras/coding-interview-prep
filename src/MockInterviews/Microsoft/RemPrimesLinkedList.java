package MockInterviews.Microsoft;

import java.util.*;
public class RemPrimesLinkedList {

    private boolean[] primes;

    private void makeSieve() {
        Arrays.fill(primes,true);
        primes[0] = false; primes[1] = false;
        for(int i=2; i< primes.length; i++) {
            if(primes[i]) {
                for(int j=2; j< primes.length;j++) {
                    primes[i*j] = false;
                }
            }
        }
    }

    private LinkedList<Integer> remPrimes(LinkedList<Integer> list) {
        makeSieve();
        Iterator iterator= list.iterator();
        while(iterator.hasNext()) {
            int n = (Integer) iterator.next();
            if( primes[n]) list.remove(n);
        }
        return list;

    }
}
