package Learn.ArrayAndString;

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {

        String[] words = s.split(" ");
        String[] reverse = new String[words.length];


        for(int i = 0; i < words.length; i++) {
            reverse[i] = reverse(words[i]);
        }


        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < reverse.length; i++) {
            sb.append(reverse[i]);
            if(i != reverse.length-1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public String reverse(String word) {
        char[] array = word.toCharArray();
        int i = 0, j = array.length-1;
        while(i < j) {
            char temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {

        ReverseWordsInAStringIII r = new ReverseWordsInAStringIII();
        System.out.println(r.reverseWords("Let's take LeetCode contest"));
    }
}
