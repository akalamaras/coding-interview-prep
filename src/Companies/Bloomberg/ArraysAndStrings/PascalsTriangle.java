package Companies.Bloomberg.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        if(numRows == 0)
            return ans;

        ans.add(new ArrayList<>(new ArrayList<>()));
        ans.get(0).add(1);
        int current = 1;

        while(current < numRows) {

            if(ans.size() == current)
                ans.add(new ArrayList<>());

            List<Integer> currentList = ans.get(current);

            currentList.add(1);

            for(int i = 1; i < current; i++)
                currentList.add(ans.get(current - 1).get(i - 1) + ans.get(current - 1).get(i));

            currentList.add(1);

            current++;
        }
        return ans;
    }
}
