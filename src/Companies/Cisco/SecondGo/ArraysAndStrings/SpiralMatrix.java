package Companies.Cisco.SecondGo.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> answer = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m - 1;
        int up = 0;
        int down = n - 1;

        while(answer.size() < m * n) {

            for(int i = left; i <= right && answer.size() < m * n; i++)
                answer.add(matrix[up][i]);

            for(int i = up + 1; i <=  down - 1 && answer.size() < m * n; i++)
                answer.add(matrix[i][right]);

            for(int i = right; i >= left && answer.size() < m * n; i--)
                answer.add(matrix[down][i]);

            for(int i = down - 1; i >= up + 1 && answer.size() < m * n; i--)
                answer.add(matrix[i][left]);

            left++;
            right--;
            up++;
            down--;
        }
        return answer;
    }
}
