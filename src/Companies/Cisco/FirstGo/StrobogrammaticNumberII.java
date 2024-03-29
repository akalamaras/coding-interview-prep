package Companies.Cisco.FirstGo;

import java.util.*;

public class StrobogrammaticNumberII {

    /**
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees
     * Find all strobogrammatic numbers of length n
     */

    public List<String> findStrobogrammatic(int n) {
        List<String> one = Arrays.asList("0","1","8");
        List<String> two = Arrays.asList("");
        List<String> r = two;
        if( n%2 == 1)
            r = one;
        for(int i = (n%2)+2 ; i <= n; i+= 2) {
            List<String> newList = new ArrayList<>();
            for(String str: r) {
                if (i != n)
                    newList.add("0" + str + "0");
                newList.add("1" + str + "1");
                newList.add("6" + str + "9");
                newList.add("8" + str + "8");
                newList.add("9" + str + "6");
            }
            r = newList;
        }
        return r;
    }

    public List<String> findStrob(int n) {
        return helper(n,n);
    }

    List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n-2,m);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            if(n != m) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");

        }
        return res;
    }
}
