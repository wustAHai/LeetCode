package easy;

/**
 * Created by chenz at 8:19 on 2021/2/1
 */
public class JZ05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
