package easy;

/**
 * Created by chenz at 16:10 on 2021/1/3
 */
public class L392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < t.length()) {
                if (t.charAt(j) != s.charAt(i)) {
                    j++;
                } else {
                    j++;
                    break;
                }
            }
            if (j >= t.length()) {
                return false;
            }
        }
        return true;
    }
}
