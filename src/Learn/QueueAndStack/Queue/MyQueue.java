package Learn.QueueAndStack.Queue;

import java.util.*;


// Naive implementation of the queue
public class MyQueue {

    private List<Integer> data;
    // a pointer to indicate the start position
    private int p_start;

    public MyQueue() {
        data = new ArrayList<>();
        p_start = 0;
    }

    /**
     * Inserts an element to the queue. Returns true if successful
     */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * Delete an item from the queue. Returns true if successful
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        p_start++;
        return true;
    }

    /**
     * Gets the front item from the queue
     */
    public int front() {
        return data.get(p_start);
    }

    /**
     * Checks if the queue is empty or not
     */
    public boolean isEmpty() {
        return p_start >= data.size();
    }
 }
