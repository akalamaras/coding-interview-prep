package Companies.Bloomberg.HeapStackQueue;

import java.util.Arrays;

public class MeetingRooms {

    public int meetingRooms(int[][] intervals) {

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endIterator = 0;
        for(int i = 0; i < starts.length; i++) {
            if(starts[i] < ends[endIterator])
                rooms++;
            else
                endIterator++;
        }
        return rooms;
    }
}
