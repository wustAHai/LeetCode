package easy;

import java.util.Arrays;

/**
 * Created by chenz at 7:49 on 2021/2/1
 */
public class L888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int a = Arrays.stream(A).sum();
        int b = Arrays.stream(B).sum();
        int diff = b - a;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if ((B[j] - A[i]) << 1 == diff) {
                    return new int[]{A[i], B[j]};
                }
            }
        }
        return new int[]{0, 0};
    }
}
