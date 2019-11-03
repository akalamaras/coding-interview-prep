package LinearProgress.Week2.Day14;

public class ReverseString {

    // has to be done in place

    private void reverseString(char[] s) {
        for(char ch: s) System.out.print(ch+" ");
        System.out.println();
            int pointer1 = 0, pointer2 = s.length-1;
            while(pointer1 < pointer2) {
                char temp = s[pointer1];
                s[pointer1] = s[pointer2];
                s[pointer2] = temp;
                pointer1++;
                pointer2--;
            }
        for(char ch: s) System.out.print(ch+" ");
    }

    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        char[] array = {'H','e','l','l','o'};
        r.reverseString(array);

    }
}
