package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenz at 14:38 on 2021/1/27
 */
public class L575 {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            integers.add(candyType[i]);
        }
        return n / 2 < integers.size() ? n / 2 : integers.size();
    }
}
