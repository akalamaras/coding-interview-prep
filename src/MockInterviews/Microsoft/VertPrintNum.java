package MockInterviews.Microsoft;

import java.util.Stack;

public class VertPrintNum {

    private void printVert(int num) {
        Stack<Integer> stack = new Stack<>();
        while(num>0) {
            int d = num%10;
            stack.push(d);
            num = num/10;
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        VertPrintNum vpn = new VertPrintNum();
        vpn.printVert(13567867);
    }
}
