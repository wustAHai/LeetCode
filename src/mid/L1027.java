package mid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenz at 1:33 on 2023/4/22 .
 */
public class L1027 {
    public int longestArithSeqLength(int[] nums) {
        int ret = 0;
        Map<Integer,Integer>[] maps = new HashMap[nums.length];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>(64);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < maps.length; i++) {
            set.clear();
            for (int j = i-1; j >=0 ; j--) {
                int d = nums[i]-nums[j];
                if (set.contains(d)){
                    continue;
                }else {
                    set.add(d);
                }
                int l = maps[j].getOrDefault(d,0)+1;
                ret = Math.max(l,ret);
                maps[i].put(d,Math.max(maps[i].getOrDefault(d,0),l));
            }
        }
        return ret+1;
    }
}
