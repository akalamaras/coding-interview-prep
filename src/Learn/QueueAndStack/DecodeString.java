package Learn.QueueAndStack;


import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {

        String res = "";

        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();

        int index = 0;
        while(index < s.length()) {

            char c = s.charAt(index);

            if(Character.isDigit(c)) {

                // Find the number inside the square brackets
                int count = 0;
                while(Character.isDigit(s.charAt(index)))
                    count = count * 10 + (s.charAt(index++) - '0');
                countStack.push(count);

            } else if(c == '[') {

                // push the partial string to the stack
                resStack.push(res);
                res = "";
                index++;

            } else if(c == ']') {

                // create the string
                StringBuilder sb = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for(int i = 0; i < repeatTimes; i++)
                    sb.append(res);

                res = sb.toString();
                index++;


            } else {

                // add character to the string
                res += s.charAt(index++);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("2[abc]3[cd]"));
    }
}
