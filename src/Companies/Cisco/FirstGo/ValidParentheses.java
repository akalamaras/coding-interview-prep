package Companies.Cisco.FirstGo;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {



    // Accepted , O(n) time complexity, O(n) space complexity
    public boolean isValid(String s) {

        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(map.containsKey(current)) { // if current is a closing bracket
                // take the top element ( we use a dummy value if the stack is empty
                char topElement = stack.empty() ? '#' : stack.pop();
                // if the brackets dont match return false
                if( topElement != map.get(current))
                    return false;
            } else
                // if it was an opening bracket, push to the stack
                stack.push(current);
        }
        // if the stack still has elements in it then the expression is false
        return stack.isEmpty();
    }
}
