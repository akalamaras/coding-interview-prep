package LinearProgress.Week3.Day6;

public class RemDupes {

    private int remDupes(int[] array) {

        int i = 0;
        for(int j = 0; j <array.length; j++) {
            if( array[i] != array[j]) i++;
        }
        return i+1;
    }

    public static void main(String[] args) {

        RemDupes r = new RemDupes();
        int[] A = {1,3,4,4,4,4,4,5,7};
        System.out.println(r.remDupes(A));
    }
}
