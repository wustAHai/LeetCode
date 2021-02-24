package easy;

/**
 * Created by chenz at 14:29 on 2021/1/7
 */
public class L415 {
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int l1 = num1.length();
        int l2 = num2.length();
        int r = 0;
        int n = l1 > l2 ? l1 : l2;
        for (int i = 0; i < n; i++) {
            int temp = r;
            if (i < num1.length()) {
                temp += num1.charAt(--l1) - '0';
            }
            if (i < num2.length()) {
                temp += num2.charAt(--l2) - '0';
            }
            r = temp / 10;
            temp %= 10;
            stringBuilder.append(temp);
        }
        if (r != 0) {
            stringBuilder.append(r);
        }
        return stringBuilder.reverse().toString();
    }
}
