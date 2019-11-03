package TopInterviewQuestions.Math.Easy;

public class AddDigits {

    public int formula(int num) {
        return 1 + (num - 1) % 9;
    }

    public int addDigits(int num) {

        int current = num;
        while(current > 9) {

            int sum = 0;
            while(current != 0) {

                sum += current % 10;
                current = current / 10;

            }
            current = sum;
        }
        return current;
    }
}
