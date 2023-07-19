package easy;

import java.util.Locale;

/**
 * @author chenz at 22:26 on 2022/10/13 .
 */
public class L2129 {
    public String capitalizeTitle(String title) {
        String[] s = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if (s[i].length()<=2){
                sb.append(s[i].toLowerCase());
            }else {
                sb.append(s[i].substring(0,1).toUpperCase()).append(s[i].substring(1).toLowerCase());
            }
            if (i<s.length-1){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
