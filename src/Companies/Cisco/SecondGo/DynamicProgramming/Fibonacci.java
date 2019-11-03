package Companies.Cisco.SecondGo.DynamicProgramming;

public class Fibonacci {

    public static void main(String[] args) {

        Fibonacci fib = new Fibonacci();
        System.out.println(fib.fib(29));
    }

    public int fib(int N) {

        if(N < 0)
            return -1;

        if(N == 0)
            return 0;

        int[] container = new int[N];
        container[0] = 0;
        container[1] = 1;
        for(int i = 2; i < N; i++)
            container[i] = container[i - 1] + container[i - 2];
        return container[N - 1];
    }
}
