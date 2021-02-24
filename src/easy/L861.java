package easy;

import java.util.Arrays;

public class L861 {
    public int matrixScore(int[][] A) {
        int length = A[0].length;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                continue;
            }
            for (int j = 0; j < length; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }
        int sum = 0;
        for (int j = 1; j < length; j++) {
            int nums0 = 0;
            int nums1 = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) {
                    nums0++;
                } else {
                    nums1++;
                }
            }
            if (nums0 > nums1) {
                for (int i = 0; i < A.length; i++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        int r = 1;
        for (int j = length - 1; j >= 0; j--) {
            int temp = 0;
            for (int i = 0; i < A.length; i++) {
                temp += A[i][j];
            }
            sum += temp * r;
            r = r * 2;
        }
        return sum;
    }

}
