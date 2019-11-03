package LinearProgress.Week4.Day2;

public class NumberOfArithmeticSlices {

    private int numOfSlices(int[] A) {
        int ret = 0;
        if( A == null || A.length < 3) return ret;
        int currentLength = 1;
        int currentDifference = A[1] - A[0];
        for(int i=1; i < A.length; i++) {
            int difference = A[i] - A[i-1];
            if( difference == currentDifference) currentLength++;
            else {
                if(currentLength > 2) {
                    for(int j=1; j <= currentLength-2; j++) {
                        ret += j;
                    }
                }
                currentDifference = difference;
                currentLength = 2;
            }
        }
        if(currentLength > 2) {
            for(int z=1; z <= currentLength-2; z++) {
                ret += z;
            }
        }
        return ret;

    }

    public static void main(String[] args) {

        NumberOfArithmeticSlices nas = new NumberOfArithmeticSlices();
        int[] array = {7,7,7,1,1,1};
        System.out.println(nas.numOfSlices(array));
    }
}
