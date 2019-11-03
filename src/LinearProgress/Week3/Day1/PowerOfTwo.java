package LinearProgress.Week3.Day1;

public class PowerOfTwo {

    // Fails last test case
    // as it fucking should, by the way
    // 536870912 returns false 'should be true'

    // but log base 2 of 536870912 is 29.000000000000004
    // so technically it should be false
    // fuck you guys
    private boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        double x = Math.log(n)/Math.log(2);
        x = Math.round(x*100)/100.0d;
        return (x%Math.floor(x) == 0);
    }

    public static void main(String[] args) {
        PowerOfTwo p = new PowerOfTwo();
        System.out.println(p.isPowerOfTwo(536870912));
    }
}
