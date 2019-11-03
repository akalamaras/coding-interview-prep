package Learn.Recursion;

import java.util.*;

public class PascalsTriangle1 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,numRows);
        return list;
    }

    public void helper(List<List<Integer>> list, int numRows) {
        if(numRows == 1) list.add(Collections.singletonList(1));
        else {
            helper(list,numRows-1);
            List<Integer> previousList = list.get(numRows-2);
            List<Integer> thisList = new ArrayList<>();
            for(int i=0;i<previousList.size();i++) {
                if(i==0) thisList.add(1);
                if(i>0) thisList.add(previousList.get(i-1)+previousList.get(i));
                if(i==previousList.size()-1) thisList.add(1);
            }
            list.add(thisList);
        }
    }

    public static void main(String[] args) {
        PascalsTriangle1 p = new PascalsTriangle1();
        System.out.println(p.generate(32));
    }
}
