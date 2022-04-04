package mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenz at 16:14 on 2021/3/9
 */
public class JZ56B {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> set = hashMap.keySet();
        for (Integer i : set) {
            if (hashMap.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}
