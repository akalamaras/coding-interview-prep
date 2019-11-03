package TopInterviewQuestions.SortingAndSearching.Hard;

import java.util.*;

public class ConfusingNumberII {

    public static void main(String[] args) {

        ConfusingNumberII cn2 = new ConfusingNumberII();
        System.out.println(cn2.confusingNumberII(20));
    }

    private int count = 0;
    private  Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
        put(0, 0);
        put(1, 1);
        put(6, 9);
        put(8, 8);
        put(9, 6);
    }};

    public int confusingNumberII(int N) {


        int[] nums = {0, 1, 6, 8, 9};
        dfs(0, N, nums);
        return count;
    }

    private void dfs(long start, int N, int[] num) {

        if(start > N)
            return;

        if(start <= N && isConfused(start, map))
            count++;


        for(int i = start == 0 ? 1 : 0; i < 5; i++)
            dfs(start * 10 + num[i], N, num);
    }

    private boolean isConfused(long s, Map<Integer,Integer> map) {

        long result = 0, x = s;
        while(x != 0) {

            int i = (int) x % 10;
            if(i == 2 || i == 3 || i == 4 || i == 5 || i == 7)
                return false;

            long digit = map.get(i);
            result = result * 10 + digit;
            x /= 10;
        }
        return result != s;
    }
}
