package TopInterviewQuestions.Math.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMedianFromDataStream {

    class MedianFinder {

        List<Integer> numberList;

        /** initialize your data structure here. */
        public MedianFinder() {
            numberList = new ArrayList<>();
        }

        public void addNum(int num) {
            numberList.add(num);

        }

        public double findMedian() {

            Collections.sort(numberList);
            int mid = numberList.size() / 2;

            if(numberList.size() % 2 == 0)
                return ((double) numberList.get(mid - 1) + (double) numberList.get(mid)) / 2;
            else
                return (double) numberList.get(mid);
        }
    }
}
