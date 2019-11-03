package LinearProgress.Week2.Day14;

import java.util.*;

public class MinStack {

    private int min;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
    }

    /*
     * push the min, change min to x, then push x
     */
    public void push(int x) {
        if(x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }

    /* if pop could result in min changing,
     * pop twice and change the current minimum value to the last minimum value
     */
    public void pop() {
        if(stack.pop() == min) min = stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
