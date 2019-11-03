package LinearProgress.Week2.Day12;

public class ExcelSheetColumnNumber {


    // Accepted, slow
    private int titleToNumber(String s) {

        char[] charArray = StringToArray(s);
        int[] array = arrayToNumbers(charArray);
        int i = 1, total = 0;
        for(int j=array.length-1;j>=0;j--) {
            total += array[j] * i;
            i *= 26;
        }
        return total;
    }

    private char[] StringToArray(String s) {
        char[] ret = new char[s.length()];
        for(int i=0;i<s.length();i++) {
            ret[i] = s.charAt(i);
        }
        return ret;
    }

    private int[] arrayToNumbers(char[] characters) {
        int[] array = new int[characters.length];
        for(int i=0;i<characters.length;i++) {
            array[i] = (Character.getNumericValue(characters[i])-9);
        }
        return array;
    }


    private int faster(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++) {
            result = result * 26 + (s.charAt(i)- 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber exc = new ExcelSheetColumnNumber();
        System.out.println(exc.titleToNumber("AAA"));

    }
}
