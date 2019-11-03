package Learn.Recursion;

import java.util.*;

public class PascalsTriangle2 {

    // Given a non negative integer k <= 33, return the kth index row of the Pascal's Triangle
    // Note that the row index starts at 0



    // This idea derives from binomial factor
    // For example, rowIndex = 6.
    // 1st: 1  = 1
    // 2nd: 6  = 6 / 1
    // 3rd: 15 = 6x5 / (1x2)
    // 4th: 20 = 6x5x4 / (1x2x3)
    // 5th: 15 = 6x5x4x3 / (1x2x3x4)
    // 6th: 6  = 6x5x4x3x2 / (1x2x3x4x5)
    // 7th: 1  = 6x5x4x3x2x1 / (1x2x3x4x5x6)
    public List<Integer> getRow(int index) {
        List<Integer> ret = new LinkedList<>();
        ret.add(1);
        if(index == 0) return ret;
        int a = index, b = 1;
        long current = 1; // to prevent overflow
        for(int i=1; i<index+1; i++) {
            current = current * a;
            current = current / b;
            ret.add((int)current);
            a--;
            b++;
        }
        return ret;
    }

    private List<Integer> other(int index) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for(int i=1;i <= index; i++) {
            for(int j= i-1; j >= 1; j--) {
                int temp =ret.get(j-1) + ret.get(j);
                ret.set(j,temp);
            }
            ret.add(1);
        }
        return ret;
    }

    public static void main(String[] args) {

        PascalsTriangle2 p = new PascalsTriangle2();
        System.out.println(p.getRow(6));
    }
}
