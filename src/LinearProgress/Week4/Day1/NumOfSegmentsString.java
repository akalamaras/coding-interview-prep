package LinearProgress.Week4.Day1;

public class NumOfSegmentsString {

    private int countSegments(String s) {
        int ret = 0;
        if(s == null) return ret;
        if(s.charAt(0) != ' ') ret++;
        for(int i = 1; i< s.length(); i++) {

            if(s.charAt(i) != ' ' && s.charAt(i-1) == ' ') ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        NumOfSegmentsString nss = new NumOfSegmentsString();
        System.out.println(nss.countSegments("Hello, my name is John"));
    }
}
