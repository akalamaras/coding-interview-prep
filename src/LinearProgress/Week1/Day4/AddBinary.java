package LinearProgress.Week1.Day4;

public class AddBinary {

    private String addBinary(String a, String b) {
        String result = "";
        int sum = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while( i >= 0 || j >= 0 || sum == 1 ) {
            sum += ( (i >= 0) ? a.charAt(i) - '0': 0 );
            sum += ( (j >= 0) ? b.charAt(j) - '0': 0 );
            result = (char)(sum % 2 + '0') + result;
            sum /= 2;
            i--;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {

        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("1010","1011"));
    }
}
