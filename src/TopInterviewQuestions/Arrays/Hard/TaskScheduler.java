package TopInterviewQuestions.Arrays.Hard;

import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        int[] array = new int[26];
        for(char task : tasks)
            array[task - 'A']++;

        Arrays.sort(array);

        // Find the number of unique tasks
        int i = 25;
        while(i >= 0 && array[i] == array[25])
            i--;

        // https://bit.ly/2TpYclo dont ask
        return Math.max(tasks.length, (array[25] - 1) * (n + 1) + 25 - i);
    }
}
