package Variations.Permutation;

import java.util.*;

public class PermutationSequence {

    public static void main(String[] args) {

        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(3,3));

    }

    private int count = 0;
    private String s = "";

    public String getPermutation(int n, int k) {

        if(n == 0 || k == 0)
            return "";

        backtrack(n, k, new ArrayList<>());
        return s;
    }

    private void backtrack(int n, int k, List<Integer> temp) {

        if(count > k - 1)
            return;

        if(count == k - 1 && temp.size() == n) {
            s = makeString(temp);
            count++;
            return;
        }


        if(temp.size() == n) {
            count++;
            return;
        }

        for(int i = 1; i <= n; i++) {

            if(!temp.contains(i)) {

                temp.add(i);
               // System.out.println(makeString(temp));
                backtrack(n, k, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private String makeString(List<Integer> temp) {

        StringBuilder sb = new StringBuilder();
        for(Integer n: temp)
            sb.append(n);
        return sb.toString();

    }
}
