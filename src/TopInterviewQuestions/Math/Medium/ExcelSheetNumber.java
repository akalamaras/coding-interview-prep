package TopInterviewQuestions.Math.Medium;

public class ExcelSheetNumber {

    public int titleToNumber(String s) {
        return s.equals("") ? 0 : 26 * titleToNumber(s.substring(0, s.length() - 1))
                                  + s.charAt(s.length() - 1) - 'A' + 1;
    }

    public int titleToLambda(String s) {
        return s.chars().reduce(0, (a, b) -> a * 26 + (b - 'A' + 1));
    }
}


