package easy;

/**
 * Created by chenz on 2020/12/29 9:15
 */
public class L345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String yuan = "aeiouAEIOU";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (yuan.indexOf(chars[i]) != -1) {
                stringBuilder.append(chars[i]);
            }
        }
        String a = stringBuilder.reverse().toString();
        for (int i = 0, j = 0; i < chars.length; i++) {
            if (yuan.indexOf(chars[i]) != -1) {
                chars[i] = a.charAt(j);
                j++;
            }
        }
        return new String(chars);
    }

}
