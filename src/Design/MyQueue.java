package Design;

import java.util.List;
import java.util.ArrayList;

// Inefficient Implementation
public class MyQueue {

    private List<Integer> data;
    private int startPointer;

    /**
     * Initialise your data structure here
     */
    public MyQueue() {

        data = new ArrayList<>();
        startPointer = 0;
    }

    /**
     * Insert an element into the queue. Returns true if the operation is successful
     */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * Deletes the item in front of the queue. Returns true if the operation is successful
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;

        startPointer++;
        return true;
    }

    /**
     * Returns the front item of the queue.
     */
    public int peek() {

        if (isEmpty())
            throw new IllegalStateException("Empty queue");
        return data.get(startPointer);
    }

    /**
     * Checks whether the queue is empty or not
     */
    public boolean isEmpty() {
        return startPointer >= data.size();
    }
}
