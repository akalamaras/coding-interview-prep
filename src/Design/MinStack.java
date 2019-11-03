package Design;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    /** Push element x into the stack */
    public void push(int x) {

        // If new x is the minimum, push twice
        if(x <= min) {
            stack.push(x);
            stack.push(x);
            min = x;
        } else
            stack.push(x);
    }

    /** Remove the element on top of the stack */
    public void pop() {

        // If we were to pop the min, pop twice and set min
        if(stack.pop() == min)
            min = stack.pop();
    }

    /** Get the top element */
    public int top() {
        return stack.peek();

    }

    /** Retrieve the minimum element in the stack */
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
