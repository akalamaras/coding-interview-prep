package Design;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public StackUsingQueues() {

        queue = new LinkedList<>();

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++)
            queue.add(queue.remove());
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue.isEmpty())
            throw new IllegalStateException("Empty stack");
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
