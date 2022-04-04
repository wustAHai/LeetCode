package easy;

import java.util.Arrays;

/**
 * Created by chenz at 8:35 on 2021/1/20
 */
public class L628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        return Math.max(nums[0] * nums[1] * nums[n], nums[n] * nums[n - 1] * nums[n - 2]);
    }
}
