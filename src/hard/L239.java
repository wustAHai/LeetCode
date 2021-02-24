package hard;

/**
 * Created by chenz at 11:44 on 2021/1/2
 */
public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int n = nums.length - k + 1;
        int[] res = new int[n];
        res[0] = findMax(nums, k, 0, Integer.MAX_VALUE);
        for (int i = 1; i < n; i++) {
            if (res[i - 1] <= nums[i + k - 1]) {
                res[i] = nums[i + k - 1];
            } else if (nums[i - 1] != res[i - 1]) {
                res[i] = res[i - 1];
            } else {
                res[i] = findMax(nums, k, i, res[i - 1]);
            }
        }
        return res;
    }

    public int findMax(int[] nums, int k, int i, int last) {
        int max = nums[i];
        for (int j = i + 1; j < i + k; j++) {
            max = Math.max(max, nums[j]);
            if (max == last) {
                return last;
            }
        }
        return max;
    }
}
