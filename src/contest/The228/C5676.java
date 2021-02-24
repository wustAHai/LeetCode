package contest.The228;

/**
 * Created by chenz at 10:30 on 2021/2/14
 */
public class C5676 {
    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        int n1 = 0;//010101
        int n2 = 0;//101010
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                if (chars[i] == '0') {
                    n2++;
                } else {
                    n1++;
                }
            } else {
                if (chars[i] == '0') {
                    n1++;
                } else {
                    n2++;
                }
            }
        }
        return Math.min(n1, n2);
    }
}
