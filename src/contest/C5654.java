package contest;

import java.util.Arrays;

/**
 * Created by chenz at 10:33 on 2021/1/31
 */
public class C5654 {
    public int countBalls(int lowLimit, int highLimit) {
        int n = highLimit - lowLimit - 1;
        int[] arr = new int[n + 1];
        for (int i = lowLimit; i <= highLimit; i++) {
            int temp = i;
            int sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            arr[sum]++;
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}
