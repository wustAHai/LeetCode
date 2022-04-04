package easy;

import java.util.*;

/**
 * Created by chenz on 2020/12/30 10:23
 */
public class L1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }
        list.sort(null);
        while (list.size() > 1) {
            int a = list.remove(list.size() - 1);
            int b = list.remove(list.size() - 1);
            if (b < a) {
                list.add(a - b);
                list.sort(null);
            }
        }
        if (list.size() == 0) {
            return 0;
        } else {
            return list.get(0);
        }
    }
}
