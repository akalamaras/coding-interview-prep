package Companies.Cisco.FirstGo;

public class FlowerBed {


    // Approach #1 Single Scan (Accepted, O(n) Time Complexity, O(1) space complexity)

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // In this approach we find the maximum number of flowers
        // that can be placed and compare it with n
        int m = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            int prev, next;
            if( i-1 < 0)
                prev = 0;
            else
                prev = flowerbed[i-1];
            if( i+1 >= flowerbed.length)
                next = 0;
            else
                next = flowerbed[i+1];
            if(prev == 0 && flowerbed[i] == 0 && next == 0) {
                flowerbed[i] = 1;
                m++;
            }
        }
        return n <= m;
    }

    // Approach #2 Optimized (Accepted, O(n) Time Complexity, O(1) space complexity)

    // In this approach we simply return true if we reach the intended number instead of
    // finding the maximum number of flowers that can possibly be planted
    public boolean canPlaceFlowersOptimized(int[] flowerbed, int n) {
        int m = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            int prev,next;
            if(i-1 < 0)
                prev = 0;
            else
                prev = flowerbed[i-1];
            if(i+1 >= flowerbed.length)
                next = 0;
            else
                next = flowerbed[i+1];
            if(prev == 0 && flowerbed[i] == 0 && next == 0) {
                flowerbed[i] = 1;
                m++;
                if(m == n) return true;
            }
        }
        return false;
    }
}

