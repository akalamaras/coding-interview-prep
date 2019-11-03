package Companies.Cisco.SecondGo.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumber {

    public List<String> findStrobogrammatic(int n) {

        List<String> list = new ArrayList<>();
        helper(new char[n], 0, n - 1, list);
        return list;
    }

    private void helper(char[] array, int left, int right, List<String> list) {

        // Base case
        if(left > right) {
            list.add(new String(array));
            return;
        }

        // For odd lengths
        if(left == right) {

            array[left] = '0';
            list.add(new String(array));

            array[left] = '1';
            list.add(new String(array));

            array[left] = '8';
            list.add(new String(array));

            return;
        }

        if(left != 0) {
            array[left] = '0';
            array[right] = '0';
            helper(array, left + 1, right - 1, list);
        }

        array[left] = '1';
        array[right] = '1';
        helper(array, left + 1, right - 1, list);

        array[left] = '8';
        array[right] = '8';
        helper(array, left + 1, right - 1, list);

        array[left] = '6';
        array[right] = '9';
        helper(array, left + 1, right - 1, list);

        array[left] = '9';
        array[right] = '6';
        helper(array, left + 1, right - 1, list);
    }
}
