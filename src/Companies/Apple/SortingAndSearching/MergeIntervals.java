package Companies.Apple.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 0)
            return intervals;

        Arrays.sort(intervals, (l1, l2) -> Integer.compare(l1[0],l2[0]));

        List<int[]> list = new ArrayList<>();
        int[] newInterval = intervals[0];
        list.add(newInterval);

        for(int[] interval : intervals) {
            if(interval[0] <= newInterval[1])
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                newInterval = interval;
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
