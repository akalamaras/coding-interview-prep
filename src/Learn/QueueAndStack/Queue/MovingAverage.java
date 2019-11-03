package Learn.QueueAndStack.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving
 * average of all integers in the sliding window
 *
 *  E.g :      MovingAverage m = new MovingAverage(3);
 *             m.next(1) = 1
 *             m.next(10) = (1 + 10) / 2
 *             m.next(3) = (1 + 10 + 3) / 3
 *             m.next(5) = (10 + 3 + 5) / 3
 */

public class MovingAverage {

    private Queue<Integer> queue;
    private int size;
    private int current;
    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        this.current = 0;
        this.sum = 0;
    }

    public double next(int val) {
        queue.add(val);
        current++;
        sum += val;
        if(current > size) {
            sum -= queue.peek();
            queue.poll();
            current--;
        }
        return sum / current;
    }

    public static void main(String[] args) {

        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }

}
