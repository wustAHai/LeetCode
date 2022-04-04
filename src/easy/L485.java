package easy;

/**
 * Created by chenz at 15:03 on 2021/1/18
 */
public class L485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp = 0;
            } else {
                temp++;
                max = temp > max ? temp : max;
            }
        }
        return max;
    }
}
