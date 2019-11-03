package LinearProgress.Week1.Day3;

public class LengthOfLastWord {

    private int lengthOfLastWord(String s) {
        int lastSpaceIndex = -1;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==' ') {
                lastSpaceIndex = i;
            }
        }
        if(s.length()==0) return 0;
        if(lastSpaceIndex == -1) return s.length();
        if(lastSpaceIndex == s.length()-1) return 0;
        return (s.length()-1)-lastSpaceIndex;
    }

    private int oneLiner(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }

    public static void main(String[] args) {

        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("a"));
        System.out.println(l.oneLiner("a"));
    }
}
