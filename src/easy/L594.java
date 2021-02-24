package easy;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by chenz at 10:23 on 2021/1/28
 */
public class L594 {
    public int findLHS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i :
                nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = hashMap.keySet();
        for (Integer i :
                set) {
            int n = hashMap.getOrDefault(i + 1, 0);
            if (n != 0) {
                max = Math.max(max, n + hashMap.get(i));
            }
        }
        return max;
    }
}
