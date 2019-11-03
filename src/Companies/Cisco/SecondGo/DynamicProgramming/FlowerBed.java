package Companies.Cisco.SecondGo.DynamicProgramming;

public class FlowerBed {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed.length == 0)
            return true;

        if(n == 0)
            return true;

        if(flowerbed.length == 1 && flowerbed[0] == 0)
            return true;

        if(flowerbed.length == 1 && flowerbed[0] == 1)
            return false;


        int count = 0;
        for(int i = 0; i < flowerbed.length; i++) {

            if(i == 0) {
                if(flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            } else if(i == flowerbed.length - 1) {
                if(flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            } else {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }

            if(count == n)
                return true;
        }
        return false;
    }
}
