package Companies.TwoSigma;

import java.util.*;

/**
 *  There are N students in a class. Some of them are friends, while some are not. Their friendship
 *  is transitive in nature. If A is a direct friend of B, and B is a direct friend of C, then A is
 *  an indirect friend of C. And we defined a friend circle as a group of students who are direct or
 *  indirect friends.
 *
 *  Given an N*N matrix M representing the friend relationship between students in the class.
 *  If M[i][j] = 1, then the i'th and j'th students are direct friends with each other, otherwise not.
 *  And you have to output the total number of friend circles among the students
 *
 */


public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int num = 0;
        int[] visited = new int[M.length];
        for(int i = 0; i < M.length; i++) {
            if(visited[i] == 0) {
                dfs(M, visited, i);
                num++;
            }

        }
        return num;
    }

    private void dfs(int[][] M, int[] visited, int i) {

        for(int j = 0; j < M[0].length; j++) {
            if(M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M,visited,j);
            }
        }
    }
}
