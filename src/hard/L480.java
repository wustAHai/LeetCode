package hard;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by chenz at 6:12 on 2021/2/3
 */
public class L480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        double[] result = new double[nums.length - k + 1];
        result[0] = temp[k / 2] / 2.0 + temp[(k - 1) / 2] / 2.0;
        for (int i = 1; i < result.length; i++) {
            int in = nums[i + k - 1];
            int out = nums[i - 1];
            int index = Arrays.binarySearch(temp, out);
            temp[index] = in;
            while (index + 1 < k && temp[index] > temp[index + 1]) {
                int swap = temp[index];
                temp[index] = temp[index + 1];
                temp[index + 1] = swap;
                index++;
            }
            while (index > 0 && index < k && temp[index] < temp[index - 1]) {
                int swap = temp[index];
                temp[index] = temp[index - 1];
                temp[index - 1] = swap;
                index--;
            }
            result[i] = temp[k / 2] / 2.0 + temp[(k - 1) / 2] / 2.0;
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }
}
