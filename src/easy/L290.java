package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class L290 {
    public boolean wordPattern(String pattern, String s) {
        String[] res = s.split(" ");
        if (pattern.length() != res.length) {
            return false;
        }
        HashMap<Character, String> hashMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String get = hashMap.getOrDefault(pattern.charAt(i), null);
            if (get == null) {
                hashMap.put(pattern.charAt(i), res[i]);
            } else {
                if (!get.equals(res[i])) {
                    return false;
                }
            }
        }
        Set<String> set = new HashSet<>(hashMap.values());
        Set<Character> set1 = new HashSet<>(hashMap.keySet());
        return set.size() == set1.size();
    }
}
