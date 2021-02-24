package easy;

import org.junit.Test;

/**
 * Created by chenz at 14:25 on 2021/1/4
 */
public class L409 {
    public int longestPalindrome(String s) {
        int sum = 0;
        int[] low = new int[26];
        int[] upper = new int[26];
        int flag = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch > 96) {
                ++low[ch - 'a'];
            } else {
                ++upper[ch - 'A'];
            }
        }
        for (int i = 0; i < low.length; i++) {
            if (low[i] % 2 == 0) {
                sum += low[i];
            } else {
                flag = 1;
                sum += low[i] - 1;
            }
        }
        for (int i = 0; i < upper.length; i++) {
            if (upper[i] % 2 == 0) {
                sum += upper[i];
            } else {
                flag = 1;
                sum += upper[i] - 1;
            }
        }
        return flag + sum;
    }

    @Test
    public void test() {
        System.out.println('a' + 0);
        System.out.println('z' + 0);
        System.out.println('A' + 0);
        System.out.println('Z' + 0);
        System.out.println('a' > 96);
    }
}
