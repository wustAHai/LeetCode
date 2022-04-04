package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 20:54 on 2022/2/9 .
 */
public class L2006 {
    public int countKDifference(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans = 0;
        for (Integer integer : map.keySet()) {
            ans+= map.get(integer)*map.getOrDefault(integer+k,0);
        }
        return ans;
    }
}
