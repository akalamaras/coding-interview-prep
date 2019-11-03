package Companies.Cisco.ThirdGo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean validParenthesis(String s) {

        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(map.containsKey(c)) {

                if(stack.isEmpty())
                    return false;

                char expected = map.get(c);
                char actual = stack.pop();

                if(expected != actual)
                    return false;
            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
