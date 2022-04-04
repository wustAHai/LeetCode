package easy;

/**
 * Created by chenz on 2020/12/24 8:50
 */
public class L680 {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }
        int end = s.length() - 1;
        int start = 0;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                end--;
                start++;
            } else {
                return valid(s, ++start, end) || valid(s, start, --end);
            }
        }
        return true;
    }

    public boolean valid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                end--;
                start++;
            } else {
                return false;
            }
        }
        return true;
    }
}
