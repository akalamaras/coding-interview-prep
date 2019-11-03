package Companies.Cisco.ThirdGo;

public class Fibonacci {

    public int fib(int N) {

        if(N == 0)
            return 0;
        else if(N == 1)
            return 1;
        int[] table = new int[N + 1];
        table[0] = 0;
        table[1] = 1;
        for(int i = 2; i <= N; i++)
            table[i] = table[i - 1] + table[i - 2];

        return table[N];
    }
}
