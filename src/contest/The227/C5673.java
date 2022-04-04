package contest.The227;

import java.util.Arrays;

/**
 * Created by chenz at 10:54 on 2021/2/7
 */
public class C5673 {
    public int maximumScore(int a, int b, int c) {
        int n = 0;
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        if (arr[0] + arr[1] < arr[2]) {
            return arr[0] + arr[1];
        } else {
            return (arr[0] + arr[1] + arr[2]) / 2;
        }
    }
}
