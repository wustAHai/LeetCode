package easy;

/**
 * Created by chenz at 13:19 on 2021/1/4
 */
public class L509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
