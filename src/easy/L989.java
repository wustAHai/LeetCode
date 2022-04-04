package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenz at 10:44 on 2021/1/22
 */
public class L989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int r = K;
        for (int i = A.length - 1; i >= 0; i--) {
            r = K + A[i];
            list.add(0, r % 10);
            r /= 10;
        }
        while (r > 0) {
            list.add(0, r % 10);
            r /= 10;
        }
        return list;
    }
}
