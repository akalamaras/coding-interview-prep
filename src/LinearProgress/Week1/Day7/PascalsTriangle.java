package LinearProgress.Week1.Day7;

import java.util.*;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows < 1) return list;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        list.add(firstRow);
        List<Integer> currentRow = firstRow;
        for(int i=2;i <= numRows;i++) {
            currentRow = makeLine(i,currentRow);
            list.add(currentRow);
        }
        return list;
    }

    private List<Integer> makeLine(int row, List<Integer> aboveRow) {
        List<Integer> rowNums = new ArrayList<>();
        for(int j = 0; j < row; j++) {
            int first = 0,second = 0;
            try {
                first = aboveRow.get(j - 1);
            } catch (IndexOutOfBoundsException e) {
                first = 0;
            }
            try {
                second = aboveRow.get(j);
            } catch (IndexOutOfBoundsException e) {
                second = 0;
            }
            rowNums.add(first+second);
        }
        return rowNums;
    }

    public static void main(String[] args) {

        PascalsTriangle tr = new PascalsTriangle();
        System.out.println(tr.generate(33));

    }
}
