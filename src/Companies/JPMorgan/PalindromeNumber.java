package Companies.JPMorgan;

import java.util.*;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if(x < 0) return false;
        List<Integer> list = split(x);
        int left = 0, right = list.size()-1;
        while(left < right) {
            if(list.get(left++) != list.get(right--))
                return false;

        }
        return true;




    }

    public List<Integer> split(int x) {
        List<Integer> list = new ArrayList<>();
        while(x != 0) {
            int add = x%10;
            list.add(add);
            x = x / 10;
        }
        return list;


    }

    public static void main(String[] args) {

        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(0));
    }
}
