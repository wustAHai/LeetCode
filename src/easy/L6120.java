package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 14:41 on 2022/7/17 .
 */
public class L6120 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] ans = new int[2];

        for (Integer value : map.values()) {
            ans[0]+=value/2;
        }
        ans[1] = nums.length - ans[0]*2;
        return ans;
    }
}
