package contest;

import org.junit.Test;

public class C5631 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return nums[0] + nums[1];
        }
        int sum = nums[0] + nums[n - 1];
        for (int i = 0; i < n - 1; ) {
            int j = i + 1;
            int temp = Integer.MIN_VALUE;
            int index = -1;
            for (; j < Math.min(n - 1, i + k + 1); j++) {
                System.out.println("j  " + j);
                if (temp < nums[j]) {
                    temp = nums[j];
                    index = j;
                    if (temp > 0) {
                        break;
                    }
                }
            }
            if (temp < 0 && i + k >= n - 1) {
                return sum;
            } else {
                sum += temp;
                i = index;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        // [1,-1,-2,4,-7,3], k = 2
        System.out.println(maxResult(new int[]{100, -1, -100, -1, 100}, 2));
    }
}
