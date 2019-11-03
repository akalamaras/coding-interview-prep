package LinearProgress.Week3.Day6;

import java.util.*;

public class PascalsTriangleAgain {

    private List<Integer> onlySaidRow(int index) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(index == 1) return res;
        long current = 1;
        int a = index, b =1;
        for(int i = 1; i< index; i++) {
            // binomials boy
            current = current/a*b;
            res.add((int)current);
            a--; b++;

        }
        return res;
    }

    private List<List<Integer>> generateAllRows(int depth) {
        List<List<Integer>> list = new ArrayList<>();
        addRow(list,depth);
        return list;
    }

    private void addRow(List<List<Integer>> list, int depth) {
        if(depth == 1) list.add(Collections.singletonList(1));
        else {
            addRow(list,depth-1);
            List<Integer> over  = list.get(depth-2);
            List<Integer> current = new ArrayList<>();
            for(int i = 0; i < over.size(); i++) {
                if(i == 0) current.add(1);
                if(i > 0) current.add(over.get(i-1)+over.get(i));
                if(i == over.size()-1) current.add(1);
            }
            list.add(current);
        }
    }

    public static void main(String[] args) {
        PascalsTriangleAgain p = new PascalsTriangleAgain();
        System.out.println(p.generateAllRows(7));
    }
}
