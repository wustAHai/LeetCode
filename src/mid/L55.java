package mid;

/**
 * Created by chenz on 2020/12/27 10:07
 */
public class L55 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (i + nums[i] >= length - 1) {
                return true;
            } else if (nums[i] == 0) {
                return false;
            } else {
                int max = 0;
                int temp = i;
                for (int j = 0; j < nums[temp]; j++) {
                    if (max < nums[temp + j + 1] + j) {
                        max = nums[temp + j + 1] + j;
                        i = temp + j + 1;
                    }
                }
            }
        }
        return true;
    }
}
