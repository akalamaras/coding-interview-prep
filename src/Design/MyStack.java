package Design;

import java.util.List;
import java.util.ArrayList;

public class MyStack {

    private List<Integer> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    /**
     * Insert an element into the stack.
     */
    public void push(int x) {
        data.add(x);
    }

    /**
     * Delete an element from the queue. Return true if the operation is successful.
     */
    public boolean pop() {
        if (isEmpty())
            return false;

        data.remove(data.size() - 1);
        return true;

    }

    /**
     * Get the top item from the queue.
     */
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Empty stack");
        return data.get(data.size() - 1);
    }

    /**
     * Checks whether the stack is empty or not
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
