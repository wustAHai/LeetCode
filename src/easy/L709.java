package easy;

/**
 * @author chenz at 12:06 on 2021/12/12 .
 */
public class L709 {
    public String toLowerCase(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(Character.toLowerCase(s.charAt(i)));
        }
        return stringBuilder.toString();
    }
}
