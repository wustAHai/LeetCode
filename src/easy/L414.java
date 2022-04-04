package easy;

/**
 * Created by chenz at 17:47 on 2021/1/12
 */
public class L414 {
    public int arrangeCoins(int n) {
        int k = 0;
        long sum = (k + 1) * k / 2;
        while (sum <= n) {
            k++;
            sum = (k + 1) * k / 2;
        }
        return --k;
    }
}
