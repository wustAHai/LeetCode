package contest.The227;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by chenz at 11:33 on 2021/2/7
 */
public class C5675 {
    //超时还需要 优化 剪枝
    int result = Integer.MAX_VALUE;

    public int minAbsDifference(int[] nums, int goal) {
        int i = 0;
        int sum = 0;
        dfs(nums, i, sum, goal);
        return result;
    }

    private void dfs(int[] nums, int i, int sum, int goal) {
        result = Math.min(result, Math.abs(sum - goal));
        if (result == 0) {
            return;
        }
        if (i == nums.length) {
            return;
        }
        dfs(nums, i + 1, sum + nums[i], goal);
        dfs(nums, i + 1, sum, goal);
    }

    @Test
    public void test() {
        int[] nums = new int[]{5, -7, 3, 5};
        int tag = 6;
        minAbsDifference(nums, tag);
    }
}
