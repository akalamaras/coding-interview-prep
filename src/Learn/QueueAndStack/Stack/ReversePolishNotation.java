package Learn.QueueAndStack.Stack;

import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String s: tokens) {
            if(s.equals("+"))
                stack.add(stack.pop()+stack.pop());
            else if(s.equals("*"))
                stack.add(stack.pop()*stack.pop());
            else if(s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            }
            else if(s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            }
            else
                stack.add(Integer.parseInt(s));

        }
        return stack.pop();
    }
}
