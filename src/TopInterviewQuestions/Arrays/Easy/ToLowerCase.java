package TopInterviewQuestions.Arrays.Easy;

public class ToLowerCase {

    public String toLowerCase(String str) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if((int) c > 64 && (int) c < 91)
                c += 32;
            sb.append(c);
        }
        return sb.toString();

    }

    public static void main(String[] args) {

        ToLowerCase tlc = new ToLowerCase();
        System.out.println(tlc.toLowerCase("HELLOstrangerR"));
    }
}
