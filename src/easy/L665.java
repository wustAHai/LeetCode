package easy;

/**
 * Created by chenz at 8:06 on 2021/2/7
 */
public class L665 {
    public boolean checkPossibility(int[] nums) {
        int n = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (i > 1 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                    n++;
                } else {
                    nums[i - 1] = nums[i];
                    n++;
                }
            }
            if (n == 2) {
                return false;
            }
        }
        return true;
    }
}
