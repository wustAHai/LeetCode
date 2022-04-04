package mid;

/**
 * Created by chenz at 9:57 on 2021/2/10
 */
public class JZ14A {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        } else if (n > 4) {
            int ans = 1;
            while (n > 4) {
                n -= 3;
                ans *= 3;
            }
            ans *= n;
            return ans;
        }
        return 0;
    }
}
