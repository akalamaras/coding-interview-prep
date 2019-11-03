package LinearProgress.Week3.Day5;

import java.util.HashMap;

public class TwoSum {

    private int[] twoSum(int[] A, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            int comp = target - A[i];
            if(map.containsKey(comp)) return new int[] {i,map.get(comp)};
            map.put(A[i],i);
        }
        System.out.println("End of loop");
        return new int[] {0,0};

    }

    public static void main(String[] args) {

        TwoSum ts = new TwoSum();
        int[] array = {1,2,3,4,5,7,9,10};
        int[] solution = ts.twoSum(array,13);
        for(int n : solution) System.out.print(n+" ");
    }
}
