package Companies.Google.OnlineAssessment;

public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] array = {0};
        FruitIntoBaskets fb = new FruitIntoBaskets();
        System.out.println(fb.totalFruit(array));
    }

    public int totalFruit2(int[] tree) {

        int result = 0, current = 0, countB = 0;
        int a = 0, b = 0;
        for(int fruit : tree) {

            current = (fruit == a || fruit == b) ? current + 1 : countB + 1;
            countB = (fruit == b) ? countB + 1 : 1;

            if(fruit != b) {
                a = b;
                b = fruit;
            }
            result = Math.max(result, current);
        }
        return result;
    }

    public int totalFruit(int[] tree) {

        if(tree == null || tree.length == 0)
            return 0;

        int[] max = new int[tree.length];
        for(int i = 0; i < tree.length; i++) {

            int firstBasket = tree[i];
            int secondBasket = tree[i];
            max[i] = 1;

            for(int j = i + 1; j < tree.length; j++) {

                if(secondBasket != firstBasket && tree[j] != firstBasket && tree[j] != secondBasket)
                    break;

                if(secondBasket == firstBasket && tree[j] != firstBasket)
                    secondBasket = tree[j];

                max[i]++;
            }
        }
        int maxNum = max[0];
        for(int n : max) {
            if( n > maxNum)
                maxNum = n;
        }
        return maxNum;
    }
}
