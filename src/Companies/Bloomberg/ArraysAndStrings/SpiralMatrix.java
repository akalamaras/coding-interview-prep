package Companies.Bloomberg.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        if(matrix == null || matrix.length == 0)
            return list;

        int n = matrix.length;
        int m = matrix[0].length;

        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;

        while(list.size() < n * m) {

            for(int j = left; j <= right && list.size() < n * m; j++)
                list.add(matrix[up][j]);

            for(int j = up + 1; j <= down - 1 && list.size() < n * m; j++)
                list.add(matrix[j][right]);

            for(int j = right; j >= left && list.size() < n * m; j--)
                list.add(matrix[down][j]);

            for(int j = down - 1; j >= up + 1 && list.size() < n * m; j--)
                list.add(matrix[j][left]);

            up++;
            down--;
            left++;
            right--;
        }
        return list;
    }
}
