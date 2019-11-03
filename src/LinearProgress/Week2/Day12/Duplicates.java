package LinearProgress.Week2.Day12;

import java.util.*;

public class Duplicates {

    private boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums) {
            if(!set.add(n)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Duplicates dupe = new Duplicates();
        int[] array = new int[] {};
        System.out.println(dupe.containsDuplicate(array));
    }
}
