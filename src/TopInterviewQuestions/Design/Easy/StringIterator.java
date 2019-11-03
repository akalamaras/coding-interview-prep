package TopInterviewQuestions.Design.Easy;

import java.util.Arrays;

class StringIterator {

    public static void main(String[] args) {

        String s = "L1e2t1C1o1d1e1";
        StringIterator iterator = new StringIterator(s);
        // System.out.println(Arrays.toString(s.toCharArray()));
        System.out.println(iterator.next());
        char[] array = s.toCharArray();
        System.out.println(array[1]);

    }



    private int charPointer, numPointer, count;
    private char[] array;

    public StringIterator(String compressedString) {

        array = compressedString.toCharArray();
        charPointer = 0;
        numPointer = 1;
        count = 0;

    }

    public char next() {

        if(!hasNext())
            return ' ';

        if(count == Character.getNumericValue(array[numPointer])) {
            count = 0;
            charPointer += 2;
            numPointer += 2;
        }

        if(!hasNext())
            return ' ';

        count++;
        return array[charPointer];
    }

    public boolean hasNext() {

        boolean first = !(charPointer > array.length -2 && numPointer > array.length - 1);
        boolean second = !(charPointer == array.length - 2 && numPointer == array.length - 1
                && count == Character.getNumericValue(array[numPointer]));

        return first && second;
    }
}
