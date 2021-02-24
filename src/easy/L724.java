package easy;

/**
 * Created by chenz at 10:05 on 2021/1/28
 */
public class L724 {
    public int pivotIndex(int[] nums) {
        long sum = 0;
        for (int i :
                nums) {
            sum += i;
        }
        int length = nums.length;
        long temp = 0;
        for (int i = 0; i < length; i++) {
            if (temp * 2 + nums[i] == sum) {
                return i;
            }
            temp += nums[i];
        }
        return -1;
    }
}
