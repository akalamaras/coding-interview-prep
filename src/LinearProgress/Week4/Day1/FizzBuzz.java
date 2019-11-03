package LinearProgress.Week4.Day1;

import java.util.*;

public class FizzBuzz {

    private List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i%5 == 0 && i%3 == 0) ret.add("FizzBuzz");
            else if( i%5 == 0) ret.add("Buzz");
            else if( i%3 == 0) ret.add("Fizz");
            else ret.add(Integer.toString(i));
        }
        return ret;
    }

    private List<String> concatenation(int n) {
        List<String> ret = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            String add = "";
            if( i%5 == 0 || i%3 == 0) {
                if( i%3 == 0) add = add + "Fizz";
                if( i%5 == 0) add = add + "Buzz";
                ret.add(add);
            }
            else ret.add(Integer.toString(i));
        }
        return ret;
    }

    // Best one
    private List<String> hash(int n) {
        List<String> ret = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<Integer,String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };
        for(int i =1 ; i <= n; i++) {
            String ans = "";
            for(Integer key : map.keySet()) {
                // if the number is divisible   by key,
                // then add the corresponding string mapping to current ans
                if( i%key == 0) ans += map.get(key);
            }

            if( ans.equals("")) ans += Integer.toString(i);
            ret.add(ans);
        }
        return ret;


    }

    public static void main(String[] args) {

        FizzBuzz f = new FizzBuzz();
        List<String> list = f.fizzBuzz(15);
        for(String s : list) System.out.println(s);
    }
}
