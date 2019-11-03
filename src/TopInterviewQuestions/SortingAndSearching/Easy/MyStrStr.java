package TopInterviewQuestions.SortingAndSearching.Easy;

public class MyStrStr {

    public static void main(String[] args) {

        MyStrStr mss = new MyStrStr();
        mss.strStr("hello", "ll");
    }

    public int strStr(String haystack, String needle) {

        if(needle.isEmpty())
            return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for(int j = 0; j < needle.length(); j++) {

                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;

                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }
}
