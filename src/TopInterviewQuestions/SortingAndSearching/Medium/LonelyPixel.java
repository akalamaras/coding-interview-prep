package TopInterviewQuestions.SortingAndSearching.Medium;

public class LonelyPixel {

    public int findLonelyPixel(char[][] picture) {

        int count = 0;
        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[0].length; j++) {
                if(picture[i][j] == 'B' && dfs(picture, i, j))
                    count++;
            }
        }
        return count;
    }

    private boolean dfs(char[][] picture, int i, int j) {

        if(i < 0 || i > picture.length - 1 || j < 0 || j > picture[0].length - 1)
            return true;

        if(picture[i][j] == 'B')
            return false;

        return dfs(picture, i + 1, j) && dfs(picture, i - 1, j)
                && dfs(picture, i, j + 1) && dfs(picture, i, j - 1);
    }
}



class LonelyPixel2 {

    public int findLonelyPixel(char[][] picture) {

        int n = picture.length, m = picture[0].length;

        int[] rowCount = new int[n], colCount = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1)
                    count++;
            }
        }
        return count;
    }
}
