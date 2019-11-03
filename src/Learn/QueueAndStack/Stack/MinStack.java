package Learn.QueueAndStack.Stack;

import java.util.*;

/**
 *   Design a stack that supports push, pop, top, and retrieving the minimum element
 *     in constant time.
 *
 *       push(x) -- Push element x onto stack.
 *       pop() -- Removes the element on top of the stack.
 *       top() -- Get the top element.
 *       getMin() -- Retrieve the minimum element in the stack.
 *
 *
 */

public class MinStack {

    private int min;
    private Stack<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int x) {
        // only push the current min when it changes after pushing x
        if(x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop could result in min changing, pop twice and change min to the last minimum value
        if(stack.pop() == min)
            min = stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
