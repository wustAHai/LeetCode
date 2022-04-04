package mid;

/**
 * Created by chenz at 18:57 on 2021/2/11
 */
public class JZ14B {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        } else if (n > 4) {
            long ans = 1;
            while (n > 4) {
                n -= 3;
                ans %= 1000000007;
                ans *= 3;
            }
            ans *= n;
            ans %= 1000000007;
            return (int) ans;
        }
        return 0;
    }
}
