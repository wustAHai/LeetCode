package easy;

/**
 * Created by chenz at 7:34 on 2021/2/3
 */
public class JZ10 {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        while (n > 0) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
            n--;
        }
        return a;
    }

    public int numWays(int n) {
        int a = 1;
        int b = 1;
        while (n > 0) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
            n--;
        }
        return a;
    }
}
