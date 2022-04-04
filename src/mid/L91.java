package mid;

/**
 * @author chenz at 11:04 on 2021/12/21 . 高级上楼梯
 */
public class L91 {
    //递归超时
    public int numDecodings0(String s) {
        char[] chars = s.toCharArray();
        return decode(chars, 0);
    }

    private int decode(char[] chars, int i) {
        if (chars.length <= i || chars[i] == '0') {
            return 0;
        }
        if (chars.length - i == 1) {
            return 1;
        }
        int s = (chars[i] - '0') * 10 + chars[i + 1] - '0';
        if (s <= 26) {
            if (chars.length == i + 2) {
                return decode(chars, i + 1) + 1;
            } else {
                return decode(chars, i + 1) + decode(chars, i + 2);
            }
        }
        return decode(chars, i + 1);
    }

    //迭代
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (chars[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1) {
                int num = (chars[i - 2] - '0') * 10 + chars[i - 1] - '0';
                if (num <= 26 && chars[i - 2] != '0') {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[n];
    }
}
