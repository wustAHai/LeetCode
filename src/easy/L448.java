package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenz at 17:58 on 2021/1/12
 */
public class L448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {//原地算法🐂
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = Math.abs(nums[Math.abs(nums[i]) - 1]) * -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
