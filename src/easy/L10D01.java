package easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by chenz on 2020/12/25 9:36
 */
public class L10D01 { //应该从后往前merge
    public void merge(int[] A, int m, int[] B, int n) {
        int a = 0;
        int b = 0;
        if (n == 0) {
            return;
        }
        for (; a < m; a++) {
            if (A[a] >= B[0]) {
                if (b < n && B[b] <= B[0]) {
                    int temp = B[b];
                    B[b] = A[a];
                    A[a] = temp;
                    b++;
                } else {
                    int temp = B[0];
                    B[0] = A[a];
                    A[a] = temp;
                }
            }
        }
        int s = 0;
        int i = b;
        for (; a < n + m; a++) {
            if (s < b && i < n) {
                if (B[s] < B[i]) {
                    A[a] = B[s];
                    s++;
                } else {
                    A[a] = B[i];
                    i++;
                }
            } else if (s >= b) {
                A[a] = B[i];
                i++;
            } else if (i >= n) {
                A[a] = B[s];
                s++;
            }
        }
    }

    @Test
    public void test() {
        int[] a = {4, 5, 6, 0, 0, 0};
        int[] b = {1, 2, 3};
        merge(a, 3, b, 3);
    }
}
