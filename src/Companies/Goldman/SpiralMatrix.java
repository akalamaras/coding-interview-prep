package Companies.Goldman;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        SpiralMatrix sm = new SpiralMatrix();
        System.out.println(sm.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        if(matrix == null || matrix.length == 0)
            return ans;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;

        while(ans.size() < m * n) {

            for(int i = left; i <= right && ans.size() < m * n; i++)
                ans.add(matrix[up][i]);

            for(int i = up + 1; i <= down && ans.size() < m * n; i++)
                ans.add(matrix[i][right]);

            for(int i = right - 1; i >= left && ans.size() < m * n; i--)
                ans.add(matrix[down][i]);

            for(int i = down - 1; i > up && ans.size() < m * n; i--)
                ans.add(matrix[i][left]);

            left++;
            right--;
            up++;
            down--;
        }
        return ans;
    }
}
