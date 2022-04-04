package easy;

/**
 * Created by chenz at 15:47 on 2021/1/16
 */
public class L459 {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if (length < 2) {
            return false;
        }
        for (int i = 1; i <= length / 2; i++) {
            String temp = s.substring(0, i);
            if (isPattern(s, temp)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPattern(String s, String temp) {
        int sLength = s.length();
        int tempLength = temp.length();
        if (sLength % tempLength != 0) {
            return false;
        }
        int n = s.length() / tempLength;
        for (int i = 0; i < n; i++) {
            if (!s.substring(i * tempLength, (i + 1) * tempLength).equals(temp)) {
                return false;
            }
        }
        return true;
    }
}
