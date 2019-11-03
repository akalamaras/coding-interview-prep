package Design;

import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public QueueUsingStacks() {

        pushStack = new Stack<>();
        popStack = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        emptyPushStack();
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        emptyPushStack();
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean isEmpty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

    private void emptyPushStack() {
        if(popStack.isEmpty()) {
            while (!pushStack.isEmpty())
                popStack.push(pushStack.pop());
        }
    }
}
