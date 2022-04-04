package top500;

import java.util.HashMap;
import java.util.Map;

public class T3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int p = 0;
        int q = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (p < s.length() && q < s.length()) {
            Integer get = map.get(s.charAt(q));
            if (get == null || get < p) {
                map.put(s.charAt(q), q);
                q++;
                max = Math.max(max, q - p);
            } else {
                p = get + 1;
            }
        }
        return max;
    }
}
