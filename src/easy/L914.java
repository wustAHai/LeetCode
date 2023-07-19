package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 20:22 on 2022/10/17 .
 */
public class L914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i : deck) {
            int j = map.getOrDefault(i, 0) + 1;
            map.put(i, j);
        }
        for (Integer value : map.values()) {
            min = Math.min(min, value);
        }
        if (min < 2) {
            return false;
        }
        for (int i = 2; i <= min; i++) {
            boolean flag = true;
            if (min % i == 0) {
                for (Integer value : map.values()) {
                    if (value%i!=0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }
}
