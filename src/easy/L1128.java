package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenz at 9:09 on 2021/1/26
 */
public class L1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int a = dominoes[i][0] * 10 + dominoes[i][1];
            int b = dominoes[i][1] * 10 + dominoes[i][0];
            a = a > b ? a : b;
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        }
        int n = 0;
        Set<Integer> keys = hashMap.keySet();
        for (Integer integer : keys) {
            n += hashMap.get(keys) * (hashMap.get(keys) - 1) / 2;
        }
        return n;
    }
}
