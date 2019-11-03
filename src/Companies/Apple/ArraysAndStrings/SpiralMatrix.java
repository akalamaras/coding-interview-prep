package Companies.Apple.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer > spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        if(matrix == null || matrix.length == 0)
            return list;

        int m = matrix.length;
        int n = matrix[0].length;

        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        while(list.size() < m * n) {

            for(int i = left; i <= right && list.size() < m * n; i++)
                list.add(matrix[up][i]);

            for(int j = up + 1; j >= down - 1 && list.size() < m * n; j++)
                list.add(matrix[j][right]);

            for(int i = right; i >= left && list.size() < m * n; i--)
                list.add(matrix[down][i]);

            for(int j = down - 1; j >= up + 1 && list.size() < m * n; j--)
                list.add(matrix[j][left]);

            up++;
            down--;
            left++;
            right--;
        }
        return list;
    }
}
