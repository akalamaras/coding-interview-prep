package Companies.Cisco.SecondGo.ArraysAndStrings;

public class ReverseWordsInString {

    public static void main(String[] args) {

        ReverseWordsInString rev = new ReverseWordsInString();
        System.out.println(rev.reverseWords("a good   example"));


    }

    public String reverseWords(String s) {

        String[] words = s.split(" ");

        for(String str : words)
            str = str.trim();

        StringBuilder sb = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--) {

            if(!words[i].equals("")) {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        String res = sb.toString();
        return res.trim();
    }
}
