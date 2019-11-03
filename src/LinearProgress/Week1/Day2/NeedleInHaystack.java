package LinearProgress.Week1.Day2;

public class NeedleInHaystack {

    private int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int i = 0;
        while (i < haystack.length()) {
            try {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    String substring = haystack.substring(i, i + needle.length());
                    if (substring.equals(needle)) return i;
                }
                i++;
            } catch (StringIndexOutOfBoundsException e) {
                return -1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        NeedleInHaystack need = new NeedleInHaystack();
        System.out.println(need.strStr("Moo","ooo"));
    }
}
