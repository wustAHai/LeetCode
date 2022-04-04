package contest.The228;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenz at 11:01 on 2021/2/14
 */
public class C5677 {
    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        Map<Long, Long> map = new HashMap<>();
        int p = 0;
        int q = 0;
        while (q < s.length()) {
            while (q < s.length() && chars[p] == chars[q]) {
                q++;
            }
            map.put((long) q - p, map.getOrDefault((long) q - p, 0l) + 1);
            p = q;
        }
        long ans = 0;
        Set<Long> set = map.keySet();
        for (Long i :
                set) {
            ans += (i + 1) * i / 2 * map.get(i);
        }
        return (int) (ans % 1000000007);
    }
}
