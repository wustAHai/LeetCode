package easy;

import java.util.Arrays;

/**
 * Created by chenz on 2020/12/25 8:35
 */
public class L455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            if (j < g.length) {
                if (s[i] >= g[j]) {
                    j++;
                    sum++;
                }
            } else {
                break;
            }
        }
        return sum;
    }
}
