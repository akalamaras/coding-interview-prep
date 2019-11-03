package TopInterviewQuestions.SortingAndSearching.Hard;

import java.util.ArrayList;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];

        for(int i = 0; i < prerequisites.length; i++)
            graph[prerequisites[i][1]].add(prerequisites[i][0]);

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(graph, visited, dp, i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, boolean[] dp, int course) {

        if(visited[course])
            return dp[course];

        visited[course] = true;

        for(int i = 0; i < graph[course].size(); i++) {
            if(!dfs(graph, visited, dp,(int) graph[course].get(i))) {
                dp[course] = false;
                return false;
            }
        }
        dp[course] = true;
        return true;
    }
}
