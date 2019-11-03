package Learn.QueueAndStack;

import java.util.*;

public class KeysAndRooms {


    public boolean canVisitAll(List<List<Integer>> rooms) {

        Stack<Integer> dfs = new Stack<>();
        Set<Integer> seen = new HashSet<>();

        dfs.add(0);
        seen.add(0);

        while(!dfs.isEmpty()) {

            int i = dfs.pop();
            for(int j : rooms.get(i)) {

                if(!seen.contains(j)) {

                    dfs.add(j);
                    seen.add(j);
                    if(rooms.size() == seen.size())
                        return true;
                }
            }
        }
        return rooms.size() == seen.size();
    }
}
