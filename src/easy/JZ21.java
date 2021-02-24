package easy;

/**
 * Created by chenz at 0:30 on 2021/2/6
 */
public class JZ21 {
    public int[] exchange(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }
}
