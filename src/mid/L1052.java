package mid;

/**
 * Created by chenz at 22:23 on 2021/2/23
 */
public class L1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int defaultMax = 0;
        for (int i = 0; i < customers.length; i++) {
            defaultMax += customers[i] * (1 - grumpy[i]);
        }
        int maxIncrement = 0;
        int temp = 0;
        for (int i = 0; i < X - 1; i++) {
            temp += customers[i] * grumpy[i];
        }
        int p = 0;
        int q = X;
        while (q < customers.length) {
            temp += customers[q] * grumpy[q];
            maxIncrement = Math.max(maxIncrement, temp);
            q++;
            temp -= customers[p] * grumpy[p];
            p++;
        }
        return defaultMax + maxIncrement;
    }
}
