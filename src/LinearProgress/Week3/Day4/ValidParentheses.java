package LinearProgress.Week3.Day4;

import java.util.*;

public class ValidParentheses {

    private HashMap<Character,Character> mappings;

    public void  ValidParentheses() {
        this.mappings = new HashMap<>();
        this.mappings.put(')','(');
        this.mappings.put(']','[');
        this.mappings.put('}','{');
    }

    /**
     *Initialize a stack S.
     * Process each bracket of the expression one at a time.
     * If we encounter an opening bracket, we simply push it onto the stack.
     *  This means we will process it later, let us simply move onto the sub-expression ahead.
     * If we encounter a closing bracket, then we check the element on top of the stack.
     *  If the element at the top of the stack is an opening bracket of the same type,
     *  then we pop it off the stack and continue processing.
     *  Else, this implies an invalid expression.
     * In the end, if we are left with a stack still having elements,
     * then this implies an invalid expression.
     *
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(this.mappings.containsKey(c)) {
                // stack.empty returns true if empty else false
                char topElement = stack.empty() ? '#' : stack.pop();
                if(topElement != this.mappings.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()()[]{}"));
    }
}

class Solution {

    private HashMap<Character, Character> mappings;

    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
