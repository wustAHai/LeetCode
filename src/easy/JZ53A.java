package easy;

import java.util.Arrays;

/**
 * Created by chenz at 10:28 on 2021/2/16
 */
public class JZ53A {
    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return 0;
        }
        int p = index;
        int q = index;
        while (p >= 0 && nums[p] == target) {
            p--;
        }
        while (q < nums.length && nums[q] == target) {
            q++;
        }
        return q - p - 1;
    }
}
