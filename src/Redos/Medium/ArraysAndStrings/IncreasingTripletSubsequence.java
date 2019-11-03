package Redos.Medium.ArraysAndStrings;

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {

        int[] array = {5, 1, 4, 2, 3};
        IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
        System.out.println(i.increasingTriplet(array));
    }

    public boolean increasingTriplet(int[] nums) {

        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for(int n : nums) {

            if(n <= small)
                small = n;
            else if(n <= big)
                big = n;
            else
                return true;
        }
        return false;
    }
}
