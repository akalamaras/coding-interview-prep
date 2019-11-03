package Learn.QueueAndStack.Stack;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[T.length];

        for(int i: T) {
            while(!stack.isEmpty() && i > T[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;

    }

}
