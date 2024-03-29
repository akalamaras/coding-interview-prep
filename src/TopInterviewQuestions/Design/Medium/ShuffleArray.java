package TopInterviewQuestions.Design.Medium;

import java.util.Random;

public class ShuffleArray {

    class Solution {

        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int[] shuffle() {

            if(nums == null)
                return null;

            int[] a = nums.clone();
            for(int j = 1; j < a.length; j++) {
                int i = random.nextInt(j + 1);
                swap(a, i, j);
            }
            return a;
        }

        private void swap(int[] a, int i, int j) {

            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        public int[] reset() {
            return nums;
        }
    }
}
