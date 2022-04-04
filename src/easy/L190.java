package easy;

import org.junit.Test;

public class L190 {
    public int reverseBits(int n) {
        String a = Integer.toBinaryString(n);
        while (a.length() < 32) {
            a = "0" + a;
        }
        char[] b = a.toCharArray();
        for (int i = 0; i < 16; i++) {
            char temp = b[31 - i];
            b[31 - i] = b[i];
            b[i] = temp;
        }
        if (b[0] == '1') {
            b[0] = '-';
        } else {
            b[0] = '+';
        }
        a = new String(b);
        n = Integer.valueOf(a, 2);
        return n;
    }

    @Test
    public void test() {
        System.out.println(reverseBits(1));
    }
}
