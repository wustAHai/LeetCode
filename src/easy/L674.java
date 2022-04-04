package easy;

/**
 * Created by chenz at 7:57 on 2021/1/24
 */
public class L674 {
    public int findLengthOfLCIS(int[] nums) {
        int length = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                count++;
                length = Math.max(count, length);
            } else {
                count = 1;
            }
        }
        return length;
    }
}
