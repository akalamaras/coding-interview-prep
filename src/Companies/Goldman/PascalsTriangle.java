package Companies.Goldman;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt.generate(3));
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();

        if(numRows < 1)
            return list;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(new ArrayList<>(first));
        for(int i = 2; i <= numRows; i++) {

            List<Integer> temp = new ArrayList<>();
            List<Integer> prev = list.get(list.size() - 1);
            temp.add(1);
            for(int j = 1; j < list.size(); j++)
                temp.add(prev.get(j - 1) + prev.get(j));
            temp.add(1);

            list.add(temp);
        }
        return list;
    }
}
