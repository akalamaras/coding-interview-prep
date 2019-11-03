package Companies.Microsoft.ArraysAndStrings;

public class ReverseWordsInString {

    public String reverseWords(String s) {

        String[] words = s.split(" ");

        for (String w : words) {
            w = w.trim();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
