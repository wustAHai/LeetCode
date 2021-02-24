package contest.The227;

/**
 * Created by chenz at 10:36 on 2021/2/7
 */
public class C5672 {
    public boolean check(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i + 1 < n && nums[i] <= nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return true;
        }
        int j = i + 1;
        while (j + 1 < n && nums[j] <= nums[j + 1]) {
            j++;
        }
        if (j == n - 1 && nums[j] <= nums[0]) {
            return true;
        }
        return false;
    }
}
