package easy;

import org.junit.Test;

import java.util.HashSet;

public class L202 {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        HashSet<Integer> hash = new HashSet<Integer>();
        hash.add(n);
        while (true) {
            int sum = 0;
            while (n > 0) {
                int a = n % 10;
                sum += a * a;
                n /= 10;
            }
            System.out.println(sum);
            if (sum == 1) {
                return true;
            } else {
                n = sum;
                if (hash.contains(n)) {
                    return false;
                }
                hash.add(n);
            }
        }
    }

    @Test
    public void test() {
        isHappy(19);
    }
}
