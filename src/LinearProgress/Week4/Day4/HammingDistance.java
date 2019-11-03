package LinearProgress.Week4.Day4;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
