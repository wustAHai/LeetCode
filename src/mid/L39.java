package mid;

import java.util.*;

/**
 * Created by chenz at 21:32 on 2021/1/2
 */
public class L39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, temp, result);
        Set<List<Integer>> resultSet = new HashSet<>(result);
        return new ArrayList<>(resultSet);
    }

    private void dfs(int[] candidates, int i, int target, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0 && !result.contains(temp)) {
            result.add(new ArrayList<>(temp));
        }
        if (i >= candidates.length) {
            return;
        }
        if (target < candidates[i]) {
            return;
        }
        dfs(candidates, i + 1, target, temp, result);

        temp.add(candidates[i]);
        dfs(candidates, i + 1, target - candidates[i], temp, result);
        temp.remove(temp.size() - 1);
    }
}
