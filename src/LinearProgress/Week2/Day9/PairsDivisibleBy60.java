package LinearProgress.Week2.Day9;

import java.util.*;

public class PairsDivisibleBy60 {

    // Too Slow
    private int numOfPairs(int[] time) {
        int num = 0;
        for(int i = 0; i < time.length; i++) {
            for (int j = 0; j < time.length; j++) {
                if (i < j && (time[i] + time[j]) % 60 == 0) num++;
            }
        }
        return num;
    }

    private int faster(int[] time) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int t: time) {
            int d = (60 - t % 60) % 60;
            // in the HashMap, get the number of songs that if adding t equals to a multiple of 60
            ans += map.getOrDefault(d,0);
            // update the number to t % 60
            map.put(t % 60, 1 + map.getOrDefault(t % 60,0));
        }
        return ans;
    }

    private int intuitive(int[] time) {
        int answer = 0;
        if( time == null || time.length == 0) return answer;
        Map<Integer,Integer> map = new HashMap<>();
        for(int each : time) {
            int remainder = each%60;
            answer += map.getOrDefault((60-remainder)%60,0);
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] pairs = {30,20,150,100,40};
        int[] pairs2 = {60,60,60};
        PairsDivisibleBy60 p = new PairsDivisibleBy60();
        System.out.println(p.numOfPairs(pairs2));
    }
}
