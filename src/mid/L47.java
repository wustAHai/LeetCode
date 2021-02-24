package mid;

import java.util.*;

/**
 * Created by chenz at 10:50 on 2021/1/8
 */
public class L47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = first; i < n; i++) {
            if (!set.contains(output.get(i))) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
                set.add(output.get(i));
            }
        }
    }
}
