package TopInterviewQuestions.Arrays.Easy;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        int fivers = 0, tenners = 0;
        for(int n : bills) {

            if(n == 5)
                fivers++;
            else if(n == 10) {
                fivers--;
                tenners++;
            }
            else {
                if(tenners > 0) {
                    tenners--;
                    fivers--;
                }
                else
                    fivers -= 3;
            }

            if(fivers < 0)
                return false;
        }
        return true;
    }
}
