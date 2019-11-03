package MockInterviews.Microsoft;

public class ReverseStringRecursive {


    private String s;

    private String reverse(String s) {
        char[] list = s.toCharArray();
        helper(list,0,list.length-1);
        return new String(list);
    }

    private void helper(char[] list,int left,int right) {

        if(left >= right) return;

        char temp = list[left];
        list[left] = list[right];
        list[right] = temp;
        helper(list,left+1,right-1);


    }

    public static void main(String[] args) {

        ReverseStringRecursive rev = new ReverseStringRecursive();
        System.out.println(rev.reverse("hi"));
    }
}
