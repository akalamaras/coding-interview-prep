package LinearProgress.Week2.Day8;

import java.util.*;

public class PascalsTriangleTwo {

    private List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for(int i=1;i<=rowIndex;i++) {
            for(int j=i-1; j >= 1; j--) {
                int temp = ret.get(j-1) + ret.get(j);
                ret.set(j,temp);
            }
            ret.add(1);
        }
        return ret;
    }

    public static void main(String[] args) {

        PascalsTriangleTwo p = new PascalsTriangleTwo();
        System.out.println(p.getRow(2));
    }
}
