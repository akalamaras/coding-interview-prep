package Design;


public class CircularQueue {

    private int[] data;
    private int headPointer;
    private int tailPointer;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public CircularQueue(int k) {
        data = new int[k];
        headPointer = -1;
        tailPointer = -1;
        size = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {

        if (isFull())
            return false;

        if (isEmpty())
            headPointer = 0;

        tailPointer = (tailPointer + 1) % size;
        data[tailPointer] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {

        if (isEmpty())
            return false;

        if (headPointer == tailPointer) {
            headPointer = -1;
            tailPointer = -1;
            return true;
        }

        headPointer = (headPointer + 1) % size;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int getHead() {
        if (isEmpty())
            throw new IllegalStateException("Empty queue");
        return data[headPointer];

    }

    /**
     * Get the last item from the queue.
     */
    public int getTail() {
        if (isEmpty())
            throw new IllegalStateException("Empty queue");
        return data[tailPointer];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return headPointer == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tailPointer + 1) % size == headPointer;
    }
}
