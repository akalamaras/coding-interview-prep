import java.util.*;
import Support.*;


public class Playground {


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement),i};
            } else {
                map.put(nums[i],i);
            }
        }
        return new int[] {0,0};
    }

    public int searchInsertPosition(int[] nums, int target) {
        int i = 0;
        try {
            while (nums[i] < target) i++;
        } catch (ArrayIndexOutOfBoundsException e) { return i; }
        return i;
    }

    public void merge(int[] nums1,int m, int[] nums2, int n) {
        int j = 0;
        for(int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[j]) {
                nums1[i + 1] = nums1[i];
                nums1[i] = nums2[j];
                j++;
            }
        }
        int k = nums1.length-1, g = nums2.length - 1;
        while( nums1[k] == 0) {
            nums1[k] = nums2[g];
            k--; g--;

        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 3) return list;
        // sort the array
        Arrays.sort(nums);
        // for each potential first number in a triplet
        for(int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            // skip equal elements to avoid multiple triplets
            if( nums[i] != nums[i-1] || i == 0) {
                // bidirectional twoSum
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while(lo < hi) {
                    if(nums[lo] + nums[hi] == sum) {
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo+1])
                            lo++;
                        while(lo < hi && nums[hi] == nums[hi-1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum)
                        lo++;
                    else
                        hi--;
                }

            }

        }
        return list;
    }

    public boolean isValid(String s) {

        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                char top = (stack.isEmpty()) ? '#' : stack.pop();
                if( top != map.get(s.charAt(i)))
                    return false;
            } else
                stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while( l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;


            if ( l1 != null) l1 = l1.next;
            if ( l2 != null) l2 = l2.next;
        }
        if(carry > 0)
            current.next = new ListNode(carry);
        return dummyHead.next;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        // rotate
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n-j-1] = temp;
            }
        }

        // transpose
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[i][j] = temp;
            }
        }
    }


    public int reverseInteger(int x) {
        int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            ret = ret * 10 + pop;
        }
        return ret;
    }



    public int trap(int[] height) {

        if(height == null || height.length == 0)
            return 0;

        int n = height.length;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++)
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);

        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];

        return sum;
    }

    public int compress(char[] chars) {

        Map<Character, Integer> map = new HashMap<>();
        for(char c : chars)
            map.put(c, map.getOrDefault(c, 0) + 1);

        int index = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {

            Character ch = entry.getKey();
            int num = entry.getValue();
            List<Integer> digits = digify(num);

            chars[index++] = ch;
            if(digits.get(0) != 0) {

                for(int dig : digits)
                    chars[index++] = (char) (dig + '0');
            }
        }
        return index;
    }

    private List<Integer> digify(int number) {

        List<Integer> res = new ArrayList<>();

        if(number == 0) {
            res.add(0);
            return res;
        }

        while(number > 0) {
            res.add(number % 10);
            number /= 10;
        }
        return res;
    }








































}
