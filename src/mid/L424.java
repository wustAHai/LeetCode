package mid;

import java.util.Arrays;

/**
 * Created by chenz at 21:07 on 2021/2/2
 */
public class L424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] chs = new int[26];
        int p = 0;
        int q = 0;
        int maxCh = 0;
        while (q < s.length()) {
            char ch = s.charAt(q);
            chs[ch - 'A']++;
            maxCh = maxCh > chs[ch - 'A'] ? maxCh : chs[ch - 'A'];
            if (q - p + 1 - maxCh > k) {
                chs[s.charAt(p) - 'A']--;

            }
            q++;
        }
        return q - p;
    }
}
