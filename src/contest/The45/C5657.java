package contest.The45;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenz at 22:31 on 2021/2/6
 */
public class C5657 {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i :
                nums) {
            integerMap.put(i, integerMap.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = integerMap.keySet();
        int sum = 0;
        for (Integer i :
                set) {
            if (integerMap.get(i) == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
