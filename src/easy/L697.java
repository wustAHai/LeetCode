package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by chenz at 15:37 on 2021/2/20
 */
public class L697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int times = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], times);
            max = Math.max(times, max);
        }
        int ans = Integer.MAX_VALUE;
        Set<Integer> set = map.keySet();
        for (Integer i :
                set) {
            if (map.get(i) == max) {
                int s = 0;
                int e = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == i) {
                        s = j;
                        break;
                    }
                }
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] == i) {
                        e = j;
                        break;
                    }
                }
                ans = Math.min(ans, e - s + 1);
            }
        }
        return ans;
    }
}
